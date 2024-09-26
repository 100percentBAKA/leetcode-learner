/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */

var nextGreaterElement = function(nums1, nums2) {
    const ref = []

    for(let i = 0; i < nums2.length; i++) {
        let flag = true 
        let j = i + 1;

        while(j < nums2.length) {
            if(nums2[i] < nums2[j]) {
                ref[nums2[i]] = nums2[j]
                flag = false
                break
            }
            j++
        }

        if(flag) {
            ref[nums2[i]] = -1;
        }
    }

    const result = []

    for(let i = 0; i < nums1.length; i++) {
        result.push(ref[nums1[i]])
    }

    return result
};