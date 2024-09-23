/**
 * @param {number[]} nums
 * @return {number[]}
 */

var productExceptSelf = function(nums) {
    left_product = []
    right_product = []
    result = []

    let lp = 1
    let rp = 1

    for(let i = 0; i < nums.length; i++) {
        if(i === 0) {
            left_product.push(1)
        }
        else {
            lp *= nums[i - 1]
            left_product.push(lp)
        }
    }

    // for(let i = 0; i < nums.length; i++) {
    //     if(i === nums.length - 1) {
    //         right_product.push(1)
    //     }
    //     else {
    //         let j = i + 1
    //         let product = 1;

    //         while(j < nums.length) {
    //             product *= nums[j++]
    //         }

    //         right_product.push(product)
    //     }
    // }

    for(let i = nums.length - 1; i >= 0; i--) {
        if(i === nums.length - 1) {
            right_product.unshift(1)
        }
        else {
            rp *= nums[i + 1]
            right_product.unshift(rp)
        }
    }

    console.log(right_product)

    for(let i = 0; i < nums.length; i++) {
        result.push(left_product[i] * right_product[i])
    }

    return result
};