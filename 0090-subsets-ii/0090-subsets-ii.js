/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    const result = []
    const arr = []

    nums.sort((a, b) => a - b)

    const func = function(index) {
        if(index === nums.length) {
            result.push([...arr])
            return
        }

        arr.push(nums[index])
        func(index + 1)

        const element = arr.pop()
        while(index < nums.length && nums[index] === element) index++

        func(index)
    }

    func(0)

    return result
};