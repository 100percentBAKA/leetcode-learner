/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let anotherInit = init;

    return {
        increment: function() {
            anotherInit += 1;
            return anotherInit;
        },
        
        decrement: function() {
            anotherInit -= 1;
            return anotherInit;
        },

        reset: function() {
            anotherInit = init;
            return anotherInit;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */