/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
function ref(arr, k, index, srr, result) {
    if(k == 0) {
        result.push([...srr])
        return
    }

    if(index === arr.length) return

    if(arr[index] <= k) {
        srr.push(arr[index])
        ref(arr, k - arr[index], index, srr, result)
        srr.pop()
    }
    

    ref(arr, k, index + 1, srr, result)
}

var combinationSum = function(candidates, target) {
    const arr = []
    const result = []

    ref(candidates, target, 0, arr, result)

    return result
};