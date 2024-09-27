/**
 * @param {number[]} nums
 * @return {number[]}
 */

var nextGreaterElements = function(nums) {
    // maybe try iterating the arr twice

    const map = new Map()

    for(let i = 0; i < nums.length; i++) {
        let j = i + 1

        let right = true
        let left = true

        while(j < nums.length) {
            if(nums[i] < nums[j]) {
                map.set(i, nums[j])
                right = false
                break
            }
            j++
        }

        if(right) {
            // the element was not found in the right side, so search left side
            let j = 0
            while(j < i) {
                if(nums[j] > nums[i]) {
                    map.set(i, nums[j])
                    left = false
                    break
                }
                j++
            }
        }

        if(left && right) {
            map.set(i, -1)
        }
    }

    // map.forEach((k, v) => {
    //     console.log("index: " + k + " value: " + v)
    // })

    const result = []

    for(let i = 0; i < nums.length; i++) {
        result.push(map.get(i))
    }

    return result
};