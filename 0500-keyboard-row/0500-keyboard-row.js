/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    let result = []

    const firstRow = [..."qwertyuiop"]
    const secondRow = [..."asdfghjkl"]
    const thirdRow = [..."zxcvbnm"]

    const arrs = words.map((word) => {
        const reducedResult = [...word.toLowerCase()].reduce((acc, char) => {
            if(firstRow.includes(char)) {
                acc.push(1)
            }
            else if(secondRow.includes(char)) {
                acc.push(2)
            }
            else {
                acc.push(3)
            }

            return acc
        }, [])

        return reducedResult
    })

    arrs.map((arr, index) => {
        if([... new Set(arr)].length === 1) {
            result.push(words[index])
        }
    })

    return result
};