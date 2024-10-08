/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    const result = []

    for(let i = 0; i < Math.pow(2, nums.length); i++) {
        let val = i.toString(2).padStart(nums.length, '0')
        
        const arr = []
        for(let j = 0; j < val.length; j++) {
            if(val[j] === "1") {
                arr.push(nums[j])
            }
        }

        result.push(arr)
    }

    return result
};