/**
 * @param {number} n
 * @return {string[]}
 */

function ref (n, str, open, close, result) {
    if(str.length === 2 * n) {
        result.push(str)
        return
    }

    if(open < n) {
        ref(n, str + "(", open + 1, close, result)
    }

    if(close < open) {  
        ref(n, str + ")", open, close + 1, result)
    }
}

var generateParenthesis = function(n) {
    const result = []

    ref(n, "", 0, 0, result)

    return result
};