(ns chess2.army.classic.king
  (use chess2.figure)
  (use chess2.chessboard))


(defn not-check-pos? [chessboard x y color]
  true
  )

(defn check-pos? [chessboard x y color]
  (not (not-check-pos? chessboard x y color))
  )

(defn possible-move? [chessboard fromx fromy tox toy]
  (and
    (not-check-pos? chessboard tox toy (piece-color chessboard fromx fromy))
    (or 
      (and
        (or
          (= (java.lang.Math/abs (offset-x fromx tox)) 1)
          (= fromx tox))
        (or
          (= (java.lang.Math/abs (offset-y fromy toy)) 1)
          (= fromy toy))))
    (not ;not moving is not an option
      (and (= fromx tox) (fromy toy)))))

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