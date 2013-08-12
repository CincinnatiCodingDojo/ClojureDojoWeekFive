(ns clojuredojoweekfive.core
  (:gen-class))

(defn get-rank [[rank suit]]
	(str rank)
)

(defn get-suit [[rank suit]]
	(str suit)
)

(defn group-cards-by-rank [hand]
	(group-by get-rank hand)
)

(defn group-cards-by-suit [hand]
	(group-by get-suit hand)
)

(defn count-duplicates [hand duplicate-size] 
	(count (filter #(= duplicate-size %) (map count (vals (group-cards-by-rank hand)))))
)
(defn count-pairs [hand]
	(count-duplicates hand 2)
)

(defn count-three-of-a-kind [hand]
	(count-duplicates hand 3)
)

(defn count-suites [hand]
	(count (filter #(= 5 %) (map count (vals (group-cards-by-suit hand)))))
)

(defn get-hand-type [hand]
	(cond
		(= 1 (count-suites hand)) 6	
		(= 1 (count-three-of-a-kind hand)) 4
		(= 2 (count-pairs hand)) 3 
		(= 1 (count-pairs hand)) 2
		:else 1
	)
)