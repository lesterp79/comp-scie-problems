function infixToPostFix(exp) {

    var precedence = {
        "NOT": 1,
        "AND": 2,
        "OR": 3
    };

    var tokens = exp.match(/\S+/g);
    var operatorStack = new Stack();
    var outputQueue = new Queue();

    var i;
    for (i = 0; i < tokens.length; i++) {
        var current = tokens[i];

        if (isVariableOrConstantName(current)) {
            alert("Pushing variable: " + current + " to output queue");
            outputQueue.enqueue(current);
        } else if (isBinaryOperator(current)) {
            while (operatorStack.length() > 0 && (isOperator(operatorStack.peek()) && hasGreaterPrecedence(operatorStack.peek(), current, precedence))) {
                alert("Pushing operator: " + operatorStack.peek() + " from stack to queue");
                outputQueue.enqueue(operatorStack.pop());
            }
            alert("Pushing current binary operator: " + current + " to operator stack");
            operatorStack.push(current);
        } else if (isUnaryOperator(current)) {
            alert("Pushing current unary operator: " + current + " to operator stack");
            operatorStack.push(current);
        } else if (current === "(") {
            alert("Pushing left parenthesis to operator stack");
            operatorStack.push("(");
        } else if (current === ")") {
            alert("Right parentheses found");
            while (!operatorStack.isEmpty() && operatorStack.peek() !== "(") {
                alert("Pushing operator: " + operatorStack.peek() + " from stack to queue");
                outputQueue.enqueue(operatorStack.pop());
            }

            if (operatorStack.isEmpty()) {
                // Parenthesis structure is invalid.
                return null;
            } else {
                alert("Removing left parentheses from operator stack");
                operatorStack.pop();
            }
        }
    }

    while (!operatorStack.isEmpty()) {
        var operator = operatorStack.pop();

        // Parenthesis structure is invalid.
        if (operator === "(" || operator === ")") {
            return null;
        }

        outputQueue.enqueue(operator);
    }

    return outputQueue;
}

function isVariableOrConstantName(token) {
    if (isOperator(token)) {
        return false;
    }

    if (token == "(") {
        return false;
    }

    if (token == ")") {
        return false;
    }

    return token.trim().length > 0
}

function hasGreaterPrecedence(stackTopToken, token, precedenceMap) {
    return precedenceMap[stackTopToken] <= precedenceMap[token];
}

function isOperator(token) {
    switch (token) {
        case "AND":
        case "OR":
        case "NOT":
            return true;
        default:
            return false;
    }
}

function isUnaryOperator(token) {
    return token === "NOT";
}

function isBinaryOperator(token) {
    switch (token) {
        case "AND":
        case "OR":
            return true;
        default:
            return false;
    }
}

function Stack() {
    this.dataStore = [];
    this.top = 0;
    this.push = push;
    this.pop = pop;
    this.peek = peek;
    this.clear = clear;
    this.length = length;
    this.isEmpty = isEmpty;
}

function push(element) {
    this.dataStore[this.top++] = element;
}

function peek() {
    return this.dataStore[this.top - 1];
}

function pop() {
    return this.dataStore[--this.top];
}

function clear() {
    this.top = 0;
}

function length() {
    return this.top;
}

function isEmpty() {
    return this.top <= 0;
}

/*


/* Creates a new queue. A queue is a first-in-first-out (FIFO) data structure -
 * items are added to the end of the queue and removed from the front.
 */
function Queue() {

    // initialise the queue and offset
    var queue = [];
    var offset = 0;

    // Returns the length of the queue.
    this.getLength = function () {
        return (queue.length - offset);
    }

    // Returns true if the queue is empty, and false otherwise.
    this.isEmpty = function () {
        return (queue.length == 0);
    }

    /* Enqueues the specified item. The parameter is:
     *
     * item - the item to enqueue
     */
    this.enqueue = function (item) {
        queue.push(item);
    }

    /* Dequeues an item and returns it. If the queue is empty, the value
     * 'undefined' is returned.
     */
    this.dequeue = function () {

        // if the queue is empty, return immediately
        if (queue.length == 0) return undefined;

        // store the item at the front of the queue
        var item = queue[offset];

        // increment the offset and remove the free space if necessary
        if (++offset * 2 >= queue.length) {
            queue = queue.slice(offset);
            offset = 0;
        }

        // return the dequeued item
        return item;

    }

    /* Returns the item at the front of the queue (without dequeuing it). If the
     * queue is empty then undefined is returned.
     */
    this.peek = function () {
        return (queue.length > 0 ? queue[offset] : undefined);
    }

}
