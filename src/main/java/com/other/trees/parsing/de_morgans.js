function ExpTreeNode(val) {
    this.val = val;
    this.left = null;
    this.right = null;
}

function de_morgans(root, apply) {
    if (!root) {
        return null;
    } else if (root.val === "AND" || root.val === "OR") {
        if (apply) {
            root.val = root.val === "OR" ? "AND" : "OR"; // if we are transforming, switch from AND to OR and from OR to AND
        }
        root.left = de_morgans(root.left, apply); // apply DeMorgans recursively to the left
        root.right = de_morgans(root.right, apply);  // apply DeMorgans recursively to the right
        return root;
    } else if (root.val === "NOT") { // we encounter a negation operator
        if (apply) { // double negation, do not keep propagating the transformation
            return de_morgans(root.right, false);
        } else { // start transformation
            return de_morgans(root.right, true); // apply recursively to child neg node
        }
    } else { // this is a primitive value
        if (apply) { // if we are transforming, create a NOT node, make it the parent of current node and return it
            var negNode = ExpTreeNode("NOT")
            negNode.right = root;
            return negNode;
        } else {
            return root;
        }
    }
}