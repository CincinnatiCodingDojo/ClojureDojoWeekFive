(ns clojuredojoweekfive.core-test
  (:require [clojure.test :refer :all]
            [clojuredojoweekfive.core :refer :all]))

(deftest test-get-rank
	(is (= "4"
		(get-rank "4c"))))

(deftest test-get-suit
	(is (= "C" 
		(get-suit "4C"))))

(deftest can-group-cards-by-rank
	(is {"3" ["3C" "3D" "3H"], "5" ["5C"], "A" ["AH"]}  (group-cards-by-rank ["3C" "4C" "5C" "3H" "AH"]))
	;["3C" "4C" "5C" "3H" "AH"]
)

(deftest can-group-cards-by-suit
	(is {"C" ["3C" "4C" "5C"] "H" ["3H" "AH"]}  (group-cards-by-suit ["3C" "4C" "5C" "3H" "AH"]))
	;["3C" "4C" "5C" "3H" "AH"]
)

(deftest can-count-pairs
	(is (= 1 (count-pairs ["3C" "4C" "5C" "3H" "AH"])))
	(is (= 0 (count-pairs ["3C" "3D" "5C" "3H" "AH"])))
	(is (= 2 (count-pairs ["3C" "3D" "5C" "5H" "AH"])))
)

(deftest test-get-hand-type
	(is (= 1 (get-hand-type ["5C" "6D" "7H" "8S" "10D"])))
	(is (= 2 (get-hand-type ["3C" "4C" "5C" "3H" "AH"])))
	(is (= 3 (get-hand-type ["3C" "5S" "5C" "3H" "AH"])))
	(is (= 4 (get-hand-type ["5D" "5S" "5C" "3H" "AH"])))
	(is (= 6 (get-hand-type ["5D" "6D" "7D" "3D" "AD"])))
)



; (deftest can-find-three-of-a-kind
; 	(is (= false (find-three-of-a-kind ["3C" "4C" "5C" "3H" "AH"])))
; 	(is (= true (find-three-of-a-kind ["3C" "3D" "5C" "3H" "AH"])))
; 	(is (= false (find-three-of-a-kind ["3C" "3D" "5C" "5H" "AH"])))
; 	)


; (deftest can-find-two-pair
; 	(is (= false (find-two-pair ["3C" "4C" "5C" "3H" "AH"])))
; 	(is (= false (find-two-pair ["3C" "3D" "5C" "3H" "AH"])))
; 	(is (= true (find-two-pair ["3C" "3D" "5C" "5H" "AH"])))
; 	)