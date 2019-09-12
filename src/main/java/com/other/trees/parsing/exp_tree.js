function ExpTreeNode(val) {
    this.val = val;
    this.left = null;
    this.right = null;
}

function build(postFix) {
    var ops = {
        "NOT": 1,
        "AND": 1,
        "OR": 2
    };

    var binary = ["AND", "OR"]

    var stack = [];

    var tokens = postFix.match(/\S+/g);

    var i;
    for (i = 0; i < tokens.length; i++) {
        var token = tokens[i];
        var newNode = ExpTreeNode(token);
        if (isVariableOrConstantName(token, ops)) {
            stack.push(token);
        } else {
            newNode.left = stack.pop();

            if (binary.includes(token)) {
                newNode.right = stack.pop();
            }

            // add this subexpression to stack
            stack.push(token);
        }
    }

    return stack.pop();
}

function inOrder(root) {
    if (root !== null) {
        inOrder(root.left);
        console.log(root.value);
        inOrder(root.right);
    }
}