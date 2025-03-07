public class UniBHList<T> {
    private Node<T> firstNode;
    private int totalElements;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        if (firstNode == null) {
            return null; 
        }

        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public void insertAtEnd(T value) {
        Node<T> newNode = new Node<>(value);
        if (firstNode == null) {
            firstNode = newNode;  
        } else {
            Node<T> currentNode = firstNode;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode); 
        }
        totalElements++;
    }

    public void insertInOrder(T value) {
        Node<T> newNode = new Node<>(value);

        
        if (firstNode == null || ((Comparable<T>)value).compareTo(firstNode.getValue()) < 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node<T> currentNode = firstNode;
            
            while (currentNode.getNext() != null && ((Comparable<T>)value).compareTo(currentNode.getNext().getValue()) > 0) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        totalElements++;
    }

    public Node<T> removeAtEnd() {
        if (firstNode == null) {
            return null; 
        }

        if (firstNode.getNext() == null) {  
            Node<T> aux = firstNode;
            firstNode = null;
            totalElements--;
            return aux;
        }

        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null && currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        Node<T> aux = currentNode.getNext();
        currentNode.setNext(null); 
        totalElements--;
        return aux;
    }

    public Node<T> removeByValue(T value) {
        if (firstNode == null) {
            return null; 
        }

        
        if (firstNode.getValue().equals(value)) {
            return removeAtBeginning();
        }

        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getValue().equals(value)) {
                Node<T> aux = currentNode.getNext();
                currentNode.setNext(currentNode.getNext().getNext());
                totalElements--;
                return aux;
            }
            currentNode = currentNode.getNext();
        }
        return null; 
    }

    public Node<T> searchElement(T value) {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null; 
    }

    @Override
    public String toString() {
        if (this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            if (i < totalElements - 1) {
                builder.append(", ");
            }
            currentNode = currentNode.getNext();
        }

        builder.append("]");

        return builder.toString();
    }

    
    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}





