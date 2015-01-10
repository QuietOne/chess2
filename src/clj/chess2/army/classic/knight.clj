(ns chess2.army.classic.knight
  (use chess2.figure)
  (use chess2.chessboard))

(defn possible-move? [chessboard fromx fromy tox toy]
  (or
    (and
      (= (java.lang.Math/abs (offset-x fromx tox)) 2)
      (= (java.lang.Math/abs (offset-y fromy toy)) 1))
    (and
      (= (java.lang.Math/abs (offset-x fromx tox)) 1)
      (= (java.lang.Math/abs (offset-y fromy toy)) 2))))

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