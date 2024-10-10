/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    const result = []
    const arr = []

    const ref = (index, k) => {
        if(index === candidates.length) return

        if(k === 0) {
            result.push([...arr])
            return
        }

        if(candidates[index] <= k) {
            arr.push(candidates[index])
            ref(index, k - candidates[index])
            arr.pop()
        }

        ref(index + 1, k)
    }

    ref(0, target)

    return result
};