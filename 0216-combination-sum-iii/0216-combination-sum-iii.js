/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */

var combinationSum3 = function(k, n) {
    const result = []
    const arr = []
    
    const srr = []
    for(let i = 1; i < 10; i++) {
        srr.push(i)
    }

    const ref = (index, k, n) => {
        if(k < 0) return

        if(n === 0 && k === 0) {
            // console.log(`k is ${k}, pushing elements ${arr} into result`)
            result.push([...arr])
            return
        }

        if(index === srr.length) {
            return
        }

        if(srr[index] <= n) {
            arr.push(srr[index])
            ref(index + 1, k - 1, n - srr[index])
            arr.pop()
        }

        ref(index + 1, k, n)
    }

    ref(0, k, n)

    return result
};
