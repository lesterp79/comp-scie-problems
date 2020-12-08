function yard(infix) {
    var ops = {
        "NOT": 1,
        "AND": 2,
        "OR": 3
    };

    var binary = ["AND", "OR"]


    var unary = ['NOT']


    var peek = function (a) {
        return a[a.length - 1];
    }; // Returns the last element of the array being evaluated
    var stack = [];

    var output = infix.match(/\S+/g).// Transforming the string into an array
    reduce(function (output, token) {    // output is the accumulator and token the current value
        if (isVariableOrConstantName(token, ops)) {         // checking for a number
            alert("Pushing variable: " + token + " to output queue");
            output.push(token);          // adding the number to the accumulator
        }

        if (binary.includes(token)) {             // checking for an operator
            // Cheking for previous operator and its precedence
            while (peek(stack) in ops && ops[peek(stack)] <= ops[token]) {
                alert("Pushing operator: " + peek(stack) + " from stack to queue");
                output.push(stack.pop());  // moves the previous operator in the stack to the output
            }
            alert("Pushing current binary operator: " + token + " to operator stack");
            stack.push(token);             // places the new operator in the stack
        }

        if (unary.includes(token)) {
            alert("Pushing current unary operator: " + token + " to operator stack");
            stack.push(token);
        }
        // checking for left parenthesis
        if (token == '(') {
            alert("Pushing left parentheses to operator stack");
            stack.push(token);
        }
        // checking for right parenthesis and moving all the elements between them to the output
        if (token == ')') {
            alert("Right parentheses found");
            while (peek(stack) != '(') {
                alert("Pushing operator: " + peek(stack) + " from stack to queue");
                output.push(stack.pop());
            }

            if (stack.length === 0) {
                // Parenthesis structure is invalid.
                alert("Parenthesis structure is invalid.");
                return null;
            } else {
                alert("Removing left parentheses from operator stack");
                stack.pop(); // removing the left parenthesis
            }
        }
        return output;  // returning the final accumulator
    }, []); // initializing the accumulator(output) as an empty array
        // .concat(stack.reverse())  // organizing the array in a RPN way
        // .join(' '); //constructing the string again

    if (stack.length > 0) {
        return stack.reverse().reduce(function (output, operator) {

            if (operator === "(" || operator === ")") {
                alert("Parenthesis structure is invalid.");
                return null;
            }

            output.push(operator);

            return output;
        }, output).join(' ');
    } else {
            return output.join(' ');
    }

}




function isVariableOrConstantName(token, ops) {
    if (token in ops) {
        return false;
    }

    if (token == "(") {
        return false;
    }

    if (token == ")") {
        return false;
    }

    return token;
}