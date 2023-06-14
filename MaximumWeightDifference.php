<?php
// Function to calculate the maximum possible difference between weights carried by the chef and son
function calculateMaxDifference($N, $K, $weights) {
    sort($weights);  // Sort the weights in non-decreasing order

    $sonSum = array_sum(array_slice($weights, 0, $K));  // Sum of the first K weights
    $totalSum = array_sum($weights);  // Sum of all weights
    $chefSum = array_sum(array_slice($weights, -$N + $K));  // Sum of the last N - K weights

    return max($totalSum - $sonSum, $chefSum - $sonSum);
}

// Main program
$T = intval(fgets(STDIN));  // Number of test cases

for ($i = 0; $i < $T; $i++) {
    fscanf(STDIN, "%d %d", $N, $K);  // Read N and K
    $weights = array_map('intval', explode(' ', trim(fgets(STDIN))));  // Read the weights

    $maxDifference = calculateMaxDifference($N, $K, $weights);
    echo $maxDifference . "\n";
}


//File input content
//MaximumWeightDifference.php < input.txt



//Code By Aniket Chandrakant Nawale