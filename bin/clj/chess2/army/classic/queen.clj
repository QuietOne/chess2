(ns chess2.army.classic.queen
  (use chess2.figure)
  (use chess2.chessboard)
  (require [chess2.army.classic.bishop :as bishop])
  (require [chess2.army.classic.rook :as rook]))

(defn possible-move? [chessboard fromx fromy tox toy]
  (or
    (bishop/possible-move? chessboard fromx fromx tox toy)
    (rook/possible-move? chessboard fromx fromy tox toy)))

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