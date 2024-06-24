package Parser;

import ConsoleCommands.Interface.GlobalParameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SimpleXMLParser {
    private String currentNamespace = null;
    private Map<String, Integer> idMap = new HashMap<>();                                                               // map of all ids
    private Map<String, String> namespaceMap = new HashMap<>();                                                         // map of all namespaces
    private Map<Node, Integer> nodeLevelMap = new HashMap<>();                                                          // map of nodes levels in tree

    public Node parse(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Stack<Node> stack = new Stack<>();                                                                              // stack of tree nodes
        Node root = null;
        Node current = null;

        StringBuilder contentBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("<") && !line.startsWith("</")) {                                                       // opening an element

                if (!contentBuilder.isEmpty() && current != null) {
                    current.setContent(contentBuilder.toString().trim());                                               // get the file line as a string for the element
                    contentBuilder.setLength(0);
                }

                int endIndex = line.indexOf('>');
                String tagName = line.substring(1, endIndex).trim();                                                    // cut the "<" and ">" from the string
                String[] tagParts = tagName.split("\\s+");                                                              // split the string on spaces " "
                tagName = tagParts[0];

                String prefix = null;
                String localName = tagName;                                                                             // get the element name if no prefix
                if (tagName.contains(":")) {                                                                            // manage the prefix and name
                    String[] nameParts = tagName.split(":");
                    prefix = nameParts[0];
                    localName = nameParts[1];
                }

                Map<String, String> attributes = new HashMap<>();                                                       // creates map of attribute names and values
                for (int i = 1; i < tagParts.length; i++) {                                                             // iterate through the array of elements
                    String[] attrParts = tagParts[i].split("=");
                    if (attrParts.length > 1) {                                                                         // skip the root
                        String attrName = attrParts[0];
                        String attrValue = attrParts[1].replaceAll("\"", "");//noted

                        if (attrName.startsWith("xmlns")) {                                                             // get the namespace
                            String nsPrefix = attrName.substring(6);
                            currentNamespace = attrValue;
                            if (namespaceMap.get(prefix) == null)
                                namespaceMap.put(nsPrefix, attrValue);                                                  // store all namespaces (prefix, value) in a map
                        }
                        else {
                            attributes.put(attrName, attrValue);                                                        // maps the attribute name and value
                        }
                    }
                }

                Node node = new Node(localName, currentNamespace, prefix, current);                                     // create a node
                currentNamespace = null;
                for (Map.Entry<String, String> entry : attributes.entrySet()) {                                         // add the attributes to the node
                    node.addAttribute(entry.getKey(), entry.getValue());
                }

                String id = attributes.get("id");                                                                       // get the id value
                if (id == null) {                                                                                       // if not exist, generate new
                    id = generateUniqueId(current);
                    node.addAttribute("id", id);
                    idMap.put(id, 0);
                    GlobalParameters.id.add(id);
                } else {                                                                                                // if exists, check ensure uniqueness
                    id = ensureUniqueId(id);
                }
                node.setId(id);

                if (current != null) {                                                                                  // check if it is the first element (root)
                    current.addChild(node);                                                                             // add current element as a child to the previous
                }
                stack.push(node);                                                                                       // stack of elements (nodes of the tree)
                current = node;
                if (root == null) {                                                                                     // check if it is root
                    root = current;
                }
            }
            else if (line.startsWith("</")) {                                                                           // closing an element
                if (!contentBuilder.isEmpty() && current != null) {
                    current.setContent(contentBuilder.toString().trim());                                               // get the file line as a string for the element
                    contentBuilder.setLength(0);
                }
                if (!stack.isEmpty()) {                                                                                 // stack managing when closing elements
                    stack.pop();
                    if (!stack.isEmpty()) {
                        current = stack.peek();                                                                         // get the previous if not the last element (root)
                    } else {
                        current = null;                                                                                 // when the root element closes
                    }
                }
            }
            else {
                contentBuilder.append(line).append(" ");                                                                // get the element text
            }
        }
        reader.close();
        return root;
    }

    private String generateUniqueId(Node parent) {
        if (parent == null) {                                                                                           // root element
            return "1";
        }

        int level = (parent.getId().split("\\.").length);                                                               // get level

        if (!nodeLevelMap.containsKey(parent)) {                                                                        // calculate id
            nodeLevelMap.put(parent, 1);
        } else {
            nodeLevelMap.put(parent, nodeLevelMap.get(parent) + 1);
        }

        String parentId = parent.getId();
        return parentId + "." + nodeLevelMap.get(parent);                                                               // new id
    }

    private String ensureUniqueId(String id) {                                                                          // validate id if exists
        if (idMap.containsKey(id)) {
            int count = idMap.get(id) + 1;
            idMap.put(id, count);
            return id + "." + count;
        } else {
            idMap.put(id, 0);
            return id;
        }
    }
}

