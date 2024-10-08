/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums.sort((a, b) => b - a)
    const set = new Set()

    for(let i = 0; i < Math.pow(2, nums.length); i++) {
        const val = i.toString(2).padStart(nums.length, '0')

        const arr = []
        for(let j = 0; j < val.length; j++) {
            if(val[j] === "1") {
                arr.push(nums[j])
            }
        }

        set.add(JSON.stringify(arr))
    }

    const newResult = []

    Array.from(set).map(element => newResult.push(JSON.parse(element)))

    return newResult
}