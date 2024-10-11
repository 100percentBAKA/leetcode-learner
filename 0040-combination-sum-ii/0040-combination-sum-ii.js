/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

var combinationSum2 = function(candidates, target) {
    const result = []
    const arr = []

    candidates.sort((a, b) => a - b)
    
    const ref = (index, k) => {

        if(k === 0) {
            result.push([...arr])
            return
        }

        if(index === candidates.length) {
            return
        }

        let element = false;

        if(candidates[index] <= k) {
            arr.push(candidates[index])
            ref(index + 1, k - candidates[index])
            element = arr.pop()
        }

        if(element !== false) {
            while(index < candidates.length && candidates[index] === element) index++

            ref(index, k)
        }
        else {
            ref(index + 1, k)
        }
    }

    ref(0, target);

    return result
};