(ns chess2.army.classic.rook
  (use chess2.figure)
  (use chess2.chessboard))

(defn possible-move? [chessboard fromx fromy tox toy]
  (or
      (and ;same column
        (= fromx tox)
        (every? #(not-occupied? chessboard tox %) (range (inc fromy) toy)))
      (and ;same row
        (= fromy toy)
        (every? #(not-occupied? chessboard (get-x-keyword %) toy) 
                (range (inc (get-x-num fromx)) (get-x-num tox))))))

(defn eat? [chessboard fromx fromy tox toy]
  (and
    (occupied? chessboard tox toy)
    (not-same-color? chessboard fromx fromy tox toy)
    (possible-move? chessboard fromx fromy tox toy)))
    

(defn move? [chessboard fromx fromy tox toy]
  (and
    (not-occupied? chessboard tox toy)
    (possible-move? chessboard fromx fromy tox toy)))

(defn moveable? [chessboard fromx fromy tox toy]
 (and
   (valid-movement? fromx fromy tox toy)
   (or
     (eat? chessboard fromx fromy tox toy)
     (move? chessboard fromx fromy tox toy))))