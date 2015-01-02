(ns chess2.army.classic.rook
  (use chess2.chessboard))

(defn eat? [chessboard fromx fromy tox toy]
  (and
    (occupied? chessboard tox toy)
    (not-same-color? chessboard fromx fromy tox toy)
    (or
      (and ;same column
        (= fromx tox)
        (every? #(not-occupied? chessboard tox %) (range (inc fromy) toy)))
      (and ;same row
        (= fromy toy)
        (every? #(not-occupied? chessboard (get-x-keyword %) toy) 
                (range (inc (get-x-num fromx)) (get-x-num tox)))))))

(defn move? [chessboard fromx fromy tox toy]
  (and
    (not-occupied? chessboard tox toy)
    (or
      (and ;same column
        (= fromx tox)
        (every? #(not-occupied? chessboard tox %) (range (inc fromy) toy)))
      (and ;same row
        (= fromy toy)
        (every? #(not-occupied? chessboard (get-x-keyword %) toy) 
                (range (inc (get-x-num fromx)) (get-x-num tox)))))))

(defn moveable? [chessboard fromx fromy tox toy]
 (and
   (valid-movement? fromx fromy tox toy)
   (or
     (eat? chessboard fromx fromy tox toy)
     (move? chessboard fromx fromy tox toy))))

(defn available-moves [chessboard x y]
  (reduce (fn [acc column]
            (reduce (fn [acc1 row]
                      (if (moveable? chessboard x y column row)
                        (conj acc1 [column row])
                        acc1)) acc (range 8))
            ) [] [:a :b :c :d :e :f :g :h]))