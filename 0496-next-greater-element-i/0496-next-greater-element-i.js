/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */

var nextGreaterElement = function(nums1, nums2) {
    const map = new Map()

    for(let i = 0; i < nums2.length; i++) {
        let j = i + 1
        let flag = true

        while(j < nums2.length) {
            if(nums2[i] < nums2[j]) {
                flag = false // no we have found the next larger element, no need to add -1
                map.set(nums2[i], nums2[j])
                break
            }
            j++
        }

        if(flag) {
            map.set(nums2[i], -1)
        }
    }

    const result = []

    for(let i = 0; i < nums1.length; i++) {
        result.push(
            map.get(nums1[i])
        )
    }

    return result
};