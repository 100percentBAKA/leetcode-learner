var climbStairs = function(n) {
    const arr = new Array(n + 1).fill(-1);

    const ref = (n) => {
        // if (arr[n] !== -1) return arr[n]; THIS LINE SHOULD NOT BE WRITTTEN HERE AS N CAN BE NEGATIVE
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (arr[n] !== -1) return arr[n];
    
        arr[n] = ref(n - 1) + ref(n - 2);
        return arr[n];
    };

    return ref(n);
};
