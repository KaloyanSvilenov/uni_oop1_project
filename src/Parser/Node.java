package Parser;

import ConsoleCommands.Interface.GlobalParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класът Node представлява елемент в XML документ.
 * Съдържа информация за името на елемента, пространството от имена, атрибутите, съдържанието, децата и родителя.
 */
public class Node {
    private String id;
    private String name;
    private String namespace;
    private String prefix;
    private String content;
    private Map<String, String> attributes;
    private List<Node> children;
    private Node parent;

    /**
     * Конструктор за създаване на нов възел.
     *
     * @param name името на възела
     * @param namespace пространството от имена на възела
     * @param prefix префикса на възела
     * @param parent родителският възел
     */
    public Node(String name, String namespace, String prefix, Node parent) {
        this.name = name;
        this.namespace = namespace;
        this.prefix = prefix;
        this.parent = parent;
        this.attributes = new HashMap<>();
        this.children = new ArrayList<>();
        this.content = "";
    }

    /**
     * Получава ID на възела.
     *
     * @return ID на възела
     */
    public String getId() {
        return id;
    }

    /**
     * Задава ID на възела.
     *
     * @param id идентификаторът за настройка
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Получава съдържанието на възела.
     *
     * @return съдържанието на възела
     */
    public String getContent() { return content; }

    /**
     * Задава съдържанието на възела.
     *
     * @param content съдържанието за настройка
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Добавя атрибут към възела.
     *
     * @param key ключа на атрибута
     * @param value стойността на атрибута
     */
    public void addAttribute(String key, String value) {
        this.attributes.put(key, value);
    }

    /**
     * Получава стойността на атрибут по неговия ключ.
     *
     * @param key ключа на атрибута
     * @return стойността на атрибута
     */
    public String getAttribute(String key){
        return this.attributes.get(key);
    }

    /**
     * Получава всички атрибути на възела.
     *
     * @return карта на всички атрибути
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Добавя дъщерен възел към този възел.
     *
     * @param child дъщерният възел за добавяне
     */
    public void addChild(Node child) {
        this.children.add(child);
    }

    /**
     * Получава родителския възел на този възел.
     *
     * @return на родителския възел
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Получава всички дъщерни възли на този възел.
     *
     * @return списък с дъщерни възли
     */
    public List<Node> getChildren() {                                                                                   // implementation for children
        return children;
    }

    /**
     * Получава всички наследствени възли на този възел.
     *
     * @return списък с наследствени възли
     */
    public List<Node> getDescendants() {                                                                                // implementation for descendants
        List<Node> descendants = new ArrayList<>(children);
        for (Node child : children) {
            descendants.addAll(child.getDescendants());
        }
        return descendants;
    }

    /**
     * Получава всички предшестващи възли на този възел.
     *
     * @return списък с предшестващи възли
     */
    public List<Node> getAncestors() {                                                                                  // implementation for ancestors
        List<Node> ancestors = new ArrayList<>();
        Node current = this.parent;
        while (current != null) {
            ancestors.add(current);
            current = current.getParent();
        }
        return ancestors;
    }

    /**
     * Изтрива цялото поддърво, вкоренено в този възел.
     */
    public void deleteTree() {
        for (Node child : children) {                                                                                   // recursively delete all nodes
            child.deleteTree();
        }
        children.clear();
    }

    /**
     * Получава стойността на атрибут по ID на възел и ключ на атрибута.
     *
     * @param id идентификаторът на възела
     * @param key ключа на атрибута
     * @return стойността на атрибута
     */
    public String getAttributeValueById(String id, String key) {
        if (this.id != null && this.id.equals(id)) {                                                                    // find the node
            return attributes.get(key);                                                                                 // get the attribute value
        }

        for (Node child : children) {                                                                                   // recursion
            String value = child.getAttributeValueById(id, key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    /**
     * Задава стойността на атрибут чрез ID на възел и ключ на атрибута.
     *
     * @param id идентификаторът на възела
     * @param key ключа на атрибута
     * @param value стойността за задаване
     * @return true, ако атрибутът е зададен, false в противен случай
     */
    public boolean setAttributeValueById(String id, String key, String value) {
        if (this.id != null && this.id.equals(id)) {                                                                    // find the node
            attributes.put(key, value);                                                                                 // set the attribute value
            return true;
        }

        for (Node child : children) {                                                                                   // recursion
            child.setAttributeValueById(id, key, value);
        }
        return false;                                                                                                   // not found
    }

    /**
     * Получава атрибутите на всички дъщерни възли по ID на техния родителски възел.
     *
     * @param targetId идентификаторът на родителския възел
     * @return списък с дъщерни атрибути като низове
     */
    public List<String> getChildAttributesById(String targetId) {                                                       // return all children attributes in a list
        List<String> childAttributes = new ArrayList<>();
        findNodeByIdAndCollectAttributes(this, targetId, childAttributes);
        return childAttributes;
    }

    /**
     * Намира възел по ID и събира атрибути на неговите деца.
     *
     * @param node текущият възел
     * @param targetId целевият идентификатор
     * @param result до списъка за събиране на атрибути
     * @return true, ако възелът е намерен, false в противен случай
     */
    private boolean findNodeByIdAndCollectAttributes(Node node, String targetId, List<String> result) {                 // add all children attributes in a list
        if (node.getId() != null && node.getId().equals(targetId)) {                                                    // find the node
            for (Node child : node.getChildren()) {
                StringBuilder sb = new StringBuilder();
                sb.append("element ").append(child.getId()).append(" : ");
                for (Map.Entry<String, String> entry : child.getAttributes().entrySet()) {                              // append all attributes of an element
                    sb.append(entry.getKey()).append(", ");
                }

                if (!sb.isEmpty()) {                                                                                    // remove the last ", "
                    sb.setLength(sb.length() - 2);
                }
                result.add(sb.toString());                                                                              // add the ready for printing line to the list
            }
            return true;
        }
        else {
            for (Node child : node.getChildren()) {                                                                     // recursion
                if (findNodeByIdAndCollectAttributes(child, targetId, result)) {
                    return true;
                }
            }
        }
        return false;                                                                                                   // not found
    }

    /**
     * Намира възел по ID и връща неговото n-то дете.
     *
     * @param targetId идентификаторът на възела
     * @param index индекса на детето
     * @return n-тия дъщерен възел или нула, ако не бъде намерен
     */
    public Node findNodeByIdAndIndex(String targetId, int index) {
        if (this.id != null && this.id.equals(targetId)) {                                                              // find the node
            if (index >= 0 && index < this.getChildren().size()) {                                                      // return n-th child if exists
                return this.children.get(index);
            }
            return null;                                                                                                // out of bounds
        }
        else {
            for (Node child : children) {
                Node result = child.findNodeByIdAndIndex(targetId, index);                                              // recursion
                if (result != null) {
                    return result;
                }
            }
        }
        return null;                                                                                                    // not found
    }

    /**
     * Получава съдържанието на възел по неговия ID.
     *
     * @param targetId идентификаторът на възела
     * @return съдържанието на възела или нула, ако не е намерен
     */
    public String getContentById(String targetId) {
            if (this.id != null && this.id.equals(targetId)) {                                                          // find the node
            return this.getContent();                                                                                   // get the element text
        }
        else {
            for (Node child : children) {                                                                               // recursion
                String result = child.getContentById(targetId);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;                                                                                                    // not found
    }

    /**
     * Изтрива атрибут по ID на възел и ключ на атрибута.
     *
     * @param targetId идентификаторът на възела
     * @param key ключа на атрибута
     * @return true, ако атрибутът е бил изтрит, false в противен случай
     */
    public boolean deleteAttributeById(String targetId, String key) {
        if (this.id != null && this.id.equals(targetId)) {                                                              // find the node
            this.attributes.remove(key);                                                                                // delete the attribute
            return true;
        }
        else {
            for (Node child : children) {                                                                               // recursion
                if (child.deleteAttributeById(targetId, key)) {
                    return true;
                }
            }
        }
        return false;                                                                                                   // not found
    }

    /**
     * Добавя ново дете към родителски възел чрез ID на детето.
     *
     * @param newChildId ID на новото дете
     * @return true, ако детето е добавено, false в противен случай
     */
    public boolean addNewChildById(String newChildId) {
        if (GlobalParameters.id.contains(newChildId)) return false;                                                     // if id exists is invalid
        if (newChildId == null || !newChildId.contains(".")) return false;                                              // if id is invalid

        String parentId = null;
        parentId = newChildId.substring(0, newChildId.lastIndexOf('.'));                                                // get parent id
        Node parentNode = findNodeById(parentId);

        if (parentNode == null || !parentNode.getContent().isEmpty()) return false;                                     // if parent is invalid

        Node newChild = new Node("newChild", null, parentNode.prefix, parentNode);
        newChild.setId(newChildId);
        newChild.addAttribute("id", newChildId);
        GlobalParameters.id.add(newChildId);
        parentNode.addChild(newChild);
        return true;                                                                                                    // if success
    }

    /**
     * Намира възел по неговия ID.
     *
     * @param targetId идентификаторът на възела
     * @return на възела с посочения идентификатор или нула, ако не бъде намерен
     */
    private Node findNodeById(String targetId) {                                                                        // find node by id input
        return findNodeById(this, targetId);
    }

    /**
     * Рекурсивно намира възел по неговия ID.
     *
     * @param node текущият възел
     * @param targetId целевият идентификатор
     * @return на възела с посочения идентификатор или нула, ако не бъде намерен
     */
    private Node findNodeById(Node node, String targetId) {
        if (node.getId() != null && node.getId().equals(targetId)) {                                                    // find the node
            return node;
        } else {
            for (Node child : node.getChildren()) {                                                                     // recursion
                Node result = findNodeById(child, targetId);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;                                                                                                    // not found
    }

    /**
     * Връща низово представяне на възела.
     *
     * @return низовото представяне на възела
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /**
     * Връща низово представяне на възела с отстъп.
     *
     * @param level нивото на отстъп
     * @return низовото представяне на възела
     */
    private String toString(int level) {

        StringBuilder sb = new StringBuilder();
        String indent = "  ".repeat(level);                                                                             // set indentation level

        sb.append(indent).append("<");                                                                                  // open element
        if (prefix != null && !prefix.isEmpty()) {                                                                      // check for prefix
            sb.append(prefix).append(":");
        }
        sb.append(name);
        if (namespace != null && !namespace.isEmpty()) {                                                                // check for namespace
            sb.append(" xmlns");
            if (prefix != null && !prefix.isEmpty()) {                                                                  // check for prefix
                sb.append(":").append(prefix);
            }
            sb.append("=\"").append(namespace).append("\"");
        }
        for (Map.Entry<String, String> entry : attributes.entrySet()) {                                                 // iterate all attributes
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append(">");
        if (content != null && !content.isEmpty()) {                                                                    // check for text
            sb.append("\n").append(indent).append("  ").append(content).append("\n");
        }
        else {
            sb.append("\n");
            for (Node child : children) {                                                                               // print children
                sb.append(child.toString(level + 1));
            }
        }
        sb.append(indent).append("</");
        if (prefix != null && !prefix.isEmpty()) {                                                                      // check for prefix
            sb.append(prefix).append(":");
        }
        sb.append(name).append(">\n");                                                                                  // close element
        return sb.toString();
    }
}
