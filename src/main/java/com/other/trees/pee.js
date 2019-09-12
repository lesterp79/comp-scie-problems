(function() {
    'use strict';

    angular
        .module('mp.textbench')
        .service('TaskFilterService', TaskFilterService);


    TaskFilterService.$inject = ['RequestFilterService', 'SortListService'];


    function TaskFilterService(requestFilterService, sortListService) {

        this.requestFilterService = requestFilterService;
        this.sortListService = sortListService;

    };


    /**
     * @public
     * @param {String} criteriaRelationship
     * @param {String} field
     * @param {String} fieldValueRelationship
     * @param {String} value
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.createFilter = function(field, relation, value, filterArray, criteriaRelationship) {

        return this.requestFilterService.createFilter(field, relation, value, filterArray, criteriaRelationship);

    };


    /**
     * @public
     * @param {String} criteriaRelationship
     * @param {String} field
     * @param {String} fieldValueRelationship
     * @param {String} value
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.customCreateFilter = function(field, relation, value, filterArray, criteriaRelationship) {

        var filter = {
            field: field,
            fieldValueRelationship: relation,
            value: value
        };

        if(criteriaRelationship){
            filter.criteriaRelationship = criteriaRelationship;
        }

        filterArray.push(filter);

        return filterArray;

    };

    /**
     * @public
     * @param {String} criteriaRelationship
     * @param {String} field
     * @param {String} fieldValueRelationship
     * @param {String} value
     * @return [{Object}] criterionGroup
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.customCreateFilterWithCriterionGroup = function(field, fieldValueRelationship, value, criteriaRelationship, criterionGroup, filterArray) {

        var filter = {};

        filter.field = field;
        filter.fieldValueRelationship = fieldValueRelationship;
        filter.value = value;
        filter.criterionGroup = criterionGroup;

        if(criteriaRelationship){
            filter.criteriaRelationship = criteriaRelationship;
        }

        filterArray.push(filter);

        return filterArray;

    };


    /**
     * @public
     * @param {String} criteriaRelationship
     * @param {String} field
     * @param {String} fieldValueRelationship
     * @param {String} value
     * @return [{Object}] criterionGroup
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.createFilterWithCriterionGroup = function(field, fieldValueRelationship, value, criteriaRelationship, criterionGroup, filterArray) {

        return this.requestFilterService.createFilterWithCriterionGroup(field, fieldValueRelationship, value, criteriaRelationship, criterionGroup, filterArray);

    };


    /**
     * @public
     * @param {String} criteriaRelationship
     * @param {String} field
     * @param {String} fieldValueRelationship
     * @param {String} value
     * @return [{Object}] criterionGroup
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.insertCriterionGroupOnTheLastFilterItem = function(criterionGroup, filterArray) {

        return this.requestFilterService.createFilterWithCriterionGroup(null, null, null, null, criterionGroup, filterArray);

    };


    /**
     * @public
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.createPageIDsFilter = function(filterArray, pageIDsFilter) {

        //replace all blank spaces
        if(pageIDsFilter) {
            pageIDsFilter = pageIDsFilter.replace(/\s*/g,'');
        }

        if(pageIDsFilter !== ''){

            var pageIDs = pageIDsFilter.split(",");

            var inPageIDsArray = [];

            for(var i=0; i < pageIDs.length; i++){

                if(pageIDs[i].indexOf('-') === -1){

                    inPageIDsArray.push(pageIDs[i]);

                } else {

                    var pageIdRange = pageIDs[i].split('-');

                    if(pageIDs[i].startsWith("-")){
                        filterArray = this.createFilter("id", "<=", pageIdRange[1], filterArray);
                    } else {
                        if(pageIdRange.length > 1){

                            filterArray = this.createFilter("id", ">=", pageIdRange[0], filterArray);

                            if(pageIdRange[1] !==''){
                                filterArray = this.createFilter("id", "<=", pageIdRange[1], filterArray);
                            }

                        } else {
                            filterArray = this.createFilter("id", ">=", pageIdRange[0], filterArray);
                        }
                    }

                }

            }

            if(pageIDs.length > 1){

                filterArray = this.createFilter("id", "in", inPageIDsArray.toString(), filterArray);


            } else if(inPageIDsArray.length === 1){

                filterArray = this.createFilter("id", "=", inPageIDsArray[0], filterArray);

            }

        }


        return filterArray;
    }


    /**
     * @public
     * @return [{Object}] filterArray
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.createFlagsFilter = function(filterArray, flagFilter) {

        //4096 - ON_HOLD
        //1073741824 - ASSIGNMENT_READY
        //536870912 - PENDING_REVIEW
        //ALL AUTO-ANALYSIS = ASSIGNMENT_READY + PENDING_REVIEW = 1610612736
        switch(flagFilter){
            case 'Special Edit':
                filterArray = this.createFilter("handlingFlag", "&", "1", filterArray);
                break;
            case 'Auto Parsed':
                filterArray = this.createFilter("handlingFlag", "&", "2", filterArray);
                break;
            case 'Error-Page Reviewed':
                filterArray = this.createFilter("handlingFlag", "&", "131072", filterArray);
                break;
            case 'Returned with Errors':
                filterArray = this.createFilter("handlingFlag", "&", "64", filterArray);
                break;
            case 'On-Hold':
                filterArray = this.createFilter("handlingFlag", "&", "4096", filterArray);
                break;
            case 'OK for Assignment':
                filterArray = this.createFilter("handlingFlag", "&", "1073741824", filterArray);
                break;
            case 'Needs Human Review':
                filterArray = this.createFilter("handlingFlag", "&", "536870912", filterArray);
                break;
            case 'All Auto-Analysis':
                var filterGroupArray = this.createFilter("handlingFlag", "&", "1073741824", []);
                filterGroupArray = this.createFilter("handlingFlag", "&", "536870912", filterGroupArray, "or");
                filterArray = this.createFilterWithCriterionGroup(null, null, null, 'and', filterGroupArray, filterArray);

                break;
            case 'Only Others/Flagged':
                filterArray = this.createFilter("handlingFlag", ">", "0", filterArray);
        }

        return filterArray;

    };


    /**
     * @public
     * @return [{Object}] filtersIn
     * this method will add an {Object} filter to filter array.
     * */
    TaskFilterService.prototype.createCommonFilters = function(filtersIn, filterForm, isWorkflowEnabled) {

        if(filterForm.projectCodeFilter.name !== 'All'){

            if(filterForm.projectCodeFilter.id != -1){
                filtersIn = this.createFilter("projectCode.id", "=", filterForm.projectCodeFilter.id, filtersIn);
            } else {
                filtersIn = this.createFilter("projectCode.id", "=", "null", filtersIn);
            }

        }

        if(filterForm.priorityFilter.name !== 'All'){

            var priorityFilterField = 'priorityId';
            if(isWorkflowEnabled){

                priorityFilterField = 'priorityId';

            }

            filtersIn = this.createFilter(priorityFilterField, "=", filterForm.priorityFilter.id, filtersIn);

        }

        if(filterForm.contentTypeFilter.name !== 'All'){

            filtersIn = this.createFilter("type", "=", filterForm.contentTypeFilter.id, filtersIn);

        }

        filtersIn = this.createPageIDsFilter(filtersIn, filterForm.pageIDsFilter);

        filtersIn = this._createBooleanUrlFilter(filtersIn, filterForm.urlFilter);

        return this.createFlagsFilter(filtersIn, filterForm.flagFilter);
    };


    /**
     * Given a URL filter expression in an infix notation with the following syntax
     * @param filtersIn
     * @param urlFilterExp
     * @returns {{Object}[]|*}
     * @private
     */
    TaskFilterService.prototype._createBooleanUrlFilter = function (filtersIn, urlFilterExp) {
        if (!urlFilterExp) {
            return filtersIn;
        }

        // take the url filter text, parse it, tokenize it and convert from infix to postfix (reverse polish) notation to eliminate
        // parentheses and make it easier to build an expression tree from
        var postFixTokens = convertToPostFix(urlFilterExp);

        if (!postFixTokens) {
            return;
        }

        // builds an expression tree from the given array of tokens in postfix notation, returning the root of the tree
        var root = buildExpTreeFromPostFix(postFixTokens);

        // apply the DeMorgans Law to the Expression tree to facilitate the filter creation
        root = applyDeMorgans(root, false);

        // use the final expression tree to generate the group of filters for the URLs
        var urlFilterGroup = this.buildUrlFilters(root, [], "and");

        // add the URL filters to the list of existing filters using a dummy group
        return this.createFilterWithCriterionGroup("id", ">", "0", 'and', urlFilterGroup, []);

        return filtersIn.concat(urlFilterGroup);

    };

    /**
     * Use the given expression tree to generate the group of filters for the URLs.
     * @param root the root of the expression tree
     * @param filters the array accumulating the URL filters
     * @param oper the value for the "previous" binary operator
     * @returns {{Object}[]}
     */
    TaskFilterService.prototype.buildUrlFilters = function (root, filters, oper) {
        var ops = {
            "NOT": 1,
            "AND": 2,
            "OR": 3
        };

        if (root !== null) {
            if (isTerminal(root.val, ops)) {
                return this.customCreateFilter("url", "like", "%" + root.val + "%", [], oper);

            } else if (root.val === "AND" || root.val === "OR") {
                var filterGroupArrayLeft = this.buildUrlFilters(root.left, filters, root.val.toLocaleLowerCase());
                var filterGroupArrayRight = this.buildUrlFilters(root.right, filters, root.val.toLocaleLowerCase());
                var combined = filterGroupArrayRight.concat(filterGroupArrayLeft);

                if (!oper) {
                    oper = "and";
                }

                return this.customCreateFilterWithCriterionGroup("id", ">", "0", oper, combined, []);
            } else {
                return this.customCreateFilter("url", "not like", "%" + root.left.val + "%", [], oper);
            }
        }
    }

    /**
     * Returns true if the given token is considered "terminal", that is, is not an operator of parentheses.
     * @param token the token to check
     * @param ops the list of operators
     * @returns {boolean|*}  true if the given token is considered "terminal", false otherwise.
     */
    function isTerminal(token, ops) {
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

    /**
     * Apply the DeMorgans Law to the expression tree defined by the given root to facilitate the filter creation
     * @param root the root of the expression tree
     * @param apply flag that indicates if we are in the middle of a transformation
     * @returns {*} the root of the normalized expression tree
     */
    function applyDeMorgans(root, apply) {
        if (!root) {
            return null;
        } else if (root.val === "AND" || root.val === "OR") {
            if (apply) {
                root.val = root.val === "OR" ? "AND" : "OR"; // if we are transforming, switch from AND to OR and from OR to AND
            }
            root.left = applyDeMorgans(root.left, apply); // apply DeMorgans recursively to the left
            root.right = applyDeMorgans(root.right, apply);  // apply DeMorgans recursively to the right
            return root;
        } else if (root.val === "NOT") { // we encounter a negation operator
            if (apply) { // double negation, do not keep propagating the transformation
                return applyDeMorgans(root.left, false);
            } else {
                if (root.left.val === "AND" || root.left.val === "OR") {
                    return applyDeMorgans(root.left, true); // start transformation
                } else {
                    return root;
                }

            }
        } else { // this is a terminal value
            if (apply) { // if we are transforming, create a NOT node, make it the parent of current node and return it
                var negNode = new ExpTreeNode("NOT")
                negNode.left = root;
                return negNode;
            } else {
                return root;
            }
        }
    }

    /**
     * Given a URL filter expression as a string, parse it, tokenize it and convert from infix to postfix (reverse polish) notation to eliminate
     * parentheses and make it easier to build an expression tree from.
     * @param infix URL filter expression as a string (infix notation)
     * @returns {string|*} an array of tokens representing the given expression, but in postfix (reverse polish) notation
     */
    function convertToPostFix(infix) {

        if (!infix) {
            return;
        }

        var ops = {
            "NOT": 1,
            "AND": 2,
            "OR": 3
        };

        var peek = function (a) {
            return a[a.length - 1];
        }; // Returns the last element of the array being evaluated
        var stack = [];

        var output = tokenize(infix).// Transforming the string into an array
        reduce(function (output, token) {    // output is the accumulator and token the current value
            if (isTerminal(token, ops)) {         // checking for a number
                //console.log("Pushing variable: " + token + " to output queue");
                output.push(token);          // adding the number to the accumulator
            }

            if (token === "AND" || token === "OR") {             // checking for an operator
                // Checking for previous operator and its precedence
                while (peek(stack) in ops && ops[peek(stack)] <= ops[token]) {
                    //console.log("Pushing operator: " + peek(stack) + " from stack to queue");
                    output.push(stack.pop());  // moves the previous operator in the stack to the output
                }
                //console.log("Pushing current binary operator: " + token + " to operator stack");
                stack.push(token);             // places the new operator in the stack
            }

            if (token === "NOT") {
                //console.log("Pushing current unary operator: " + token + " to operator stack");
                stack.push(token);
            }
            // checking for left parenthesis
            if (token == '(') {
                //console.log("Pushing left parentheses to operator stack");
                stack.push(token);
            }
            // checking for right parenthesis and moving all the elements between them to the output
            if (token == ')') {
                //console.log("Right parentheses found");
                while (peek(stack) != '(') {
                    //console.log("Pushing operator: " + peek(stack) + " from stack to queue");
                    output.push(stack.pop());
                }

                if (stack.length === 0) {
                    // Parenthesis structure is invalid.
                    console.log("Parenthesis structure is invalid.");
                    return null;
                } else {
                    //console.log("Removing left parentheses from operator stack");
                    stack.pop(); // removing the left parenthesis
                }
            }
            return output;  // returning the final accumulator
        }, []); // initializing the accumulator(output) as an empty array

        if (stack.length > 0) {
            return stack.reverse().reduce(function (output, operator) {

                if (operator === "(" || operator === ")") {
                    console.log("Parenthesis structure is invalid.");
                    return null;
                }

                output.push(operator);

                return output;
            }, output).join(' ');
        } else {
            return output.join(' ');
        }

    }

    /**
     *  Given a URL filter expression as a string in infix notation, tokenize it.
     * @param infix a URL filter expression as a string in infix notation
     * @returns {Array} an array of tokens
     */
    function tokenize(infix) {
        var tokens = infix.split('');

        var i = 0;
        var output = [];
        while (i < tokens.length) {
            if (tokens[i] === ' ') { // whitespace
                i++; // ignore the whitespaces
            } else if (tokens[i] === '(' || tokens[i] === ')') { // parentheses
                output.push(tokens[i++]);
            } else if (tokens[i] === ',') { // comma is equivalent to OR
                output.push('OR');
                i++;
            } else { // build the token
                var token = [];
                while (i < tokens.length && tokens[i] !== '(' && tokens[i] !== ')' && tokens[i] !== ' ') {
                    token.push(tokens[i++]);
                }
                output.push(token.join(''));
            }
        }

        return output;
    }

    /**
     * Checks position and placement of (, ), and operators in a string to make sure it is a valid arithmetic expression
     *
     * @return true if the string is a valid arithmetic expression, false if not
     */
    function isValidExpression(infix) {

        var tokens = tokenize(infix);

        //TEST 1: False if expression starts or ends with an operator
        if (tokens[0] === 'AND' || tokens[0] === 'OR' || tokens[tokens.length - 1] === 'AND' || tokens[tokens.length - 1] === 'OR' || tokens[tokens.length - 1] === 'NOT') {
            //console.log("Does not start or end with operator");
            return false;
        }

        //TEST 2: False if test has mismatching number of opening and closing parantheses
        var unclosedParenthesis = 0;
        //console.log("Parentheses counter initialized to 0");

        for (var i = 0; i < tokens.size(); i++) {
            //console.log("For loop count: " + i);
            if (tokens[i] === '(') {
                //console.log("( found");
                unclosedParenthesis++;

                //SUBTEST: False if expression ends with '('
                if (i === tokens.length - 1)
                    return false;
            }
            if (tokens[i] === ')') {
                unclosedParenthesis--;
                //console.log(") found");
                //SUBTEST: False if expression starts with ')'
                if (i === 0) {
                    return false;
                }


            }
            if (tokens[0] === 'AND' || tokens[0] === 'OR') {

                //console.log("Found an Operator");
                //TEST 3: False if operator is preceded by an operator or opening paranthesis
                //or followed by closing parenthesis
                if (tokens[i - 1] === '(' || tokens[i + 1] === ')' || tokens[i + 1] === 'AND' || tokens[i + 1] === 'OR') {
                    //console.log("Incorrect placement of OR or AND operator");
                    return false;
                }

            }

            if (tokens[i] === 'NOT') {
                if ((i > 0 && (!(tokens[i - 1] === 'AND' || tokens[i - 1] === 'OR' || tokens[i - 1] === 'NOT') || tokens[1 - 1] === '(') || tokens[1 - 1] === ')')
                    || tokens[i + 1] === 'AND' || tokens[i + 1] === 'OR' || tokens[1 - 1] === ')') {
                    //console.log(""Incorrect placement of NOT operator");
                    return false;
                }
            }

        }
        return (unclosedParenthesis === 0);
    }

    /**
     * Builds an expression tree from the given array of tokens in postfix notation, returning the root of the tree.
     * @param postFix an array of tokens in postfix notation
     * @returns {*} the root of the tree
     */
    function buildExpTreeFromPostFix(postFix) {

        if (!postFix) {
            return;
        }

        var ops = {
            "NOT": 1,
            "AND": 2,
            "OR": 3
        };

        var stack = [];

        var tokens = postFix.match(/\S+/g);

        var i;
        for (i = 0; i < tokens.length; i++) {
            var token = tokens[i];
            var newNode = new ExpTreeNode(token);
            if (isTerminal(token, ops)) {
                stack.push(newNode);
            } else {
                newNode.left = stack.pop();

                if (token === "AND" || token === "OR") {
                    newNode.right = stack.pop();
                }

                // add this subexpression to stack
                stack.push(newNode);
            }
        }

        return stack.pop();
    }


    /**
     * Represents a node in a binary expression tree
     * @param val the value of this node
     * @constructor
     */
    function ExpTreeNode(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }


    /**
     * @public
     * this method will map user role variables
     * */
    TaskFilterService.prototype.mapUserRole = function(userRole) {

        var access = {
            isSUandTAMRole: false,
            isCtrManagerRole: false,
            isCtrEmployeeRole: false,
            isCustomerRole: false,
            isCustomerUserRole: false,
            isCustomerUserManagerRole: false,
            isCustomerManagerRole: false
        }

        if(userRole){

            switch (userRole) {
                case 'ROLE_MANAGER':
                case 'ROLE_SYST_ADMIN':
                    access.isSUandTAMRole = true;
                    break;
                case 'ROLE_CONTRACTOR_MANAGER':
                    access.isCtrManagerRole = true;
                    break;
                case 'ROLE_CONTRACTOR_EMPLOYEE':
                    access.isCtrEmployeeRole = true;
                    break;
                case 'ROLE_CUSTOMER':
                    access.isCustomerUserRole = true;
                    access.isCustomerRole = true;
                    break;
                case 'ROLE_CUSTOMER_MANAGER':
                    access.isCustomerManagerRole = true;
                    access.isCustomerRole = true;
                    break;
                case 'ROLE_CUSTOMER_USER_MANAGER':
                    access.isCustomerUserManagerRole = true;
                    access.isCustomerRole = true;
            }

        }

        return access;

    };


    /**
     * @public
     * this method will compare fieldValue with value to check if there is a filter not default On.
     * @param fieldValue
     * @param value
     * @return true/false. If there is not default filter ON, it will return TRUE, otherwise FALSE
     * */
    TaskFilterService.prototype.isFiltersOn = function(fieldValue, value, currentValue) {

        if(fieldValue != value || currentValue){
            return true;
        }

        return false;

    };


    /**
     * @public
     * @param {String} property or object field name to sort array
     * @return {Object} sorts objects by parameter
     */
    TaskFilterService.prototype.dynamicSort = function(property) {

        return this.sortListService.dynamicSort(property);

    };


    TaskFilterService.prototype.sort_by = function(field, reverse, primer){

        return this.sortListService.sort_by(field, reverse, primer);

    };


})();