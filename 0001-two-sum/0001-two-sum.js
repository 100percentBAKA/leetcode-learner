/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
    const map = new Map()
    const result = []

    for(let i = 0; i < nums.length; i++) {
        const diff = target - nums[i]

        if(map.has(nums[i])) {
            result.push(map.get(nums[i]))
            result.push(i)

            break
        }   
        else {
            map.set(diff, i)
        }
    }

    return result
};