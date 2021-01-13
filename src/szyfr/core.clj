(ns szyfr.core
  (:gen-class))
(defn -main
  [& args]
(defn
  zaszyfrowac-znak [offset c]
  (if (Character/isLetter c)
    (let [v (int c)
          base (if (>= v (int \a))
                 (int \a)
                 (int \A))
          offset (mod offset 26)]
      (char (+ (mod (+ (- v base) offset) 26)
               base)))
    c))

(defn zaszyfruj [offset text]
  (apply str (map #(zaszyfrowac-znak offset %) text)))

(defn odszyfruj [offset text]
  (zaszyfruj (- 26 offset) text))

(defn przekon
  []
(let [text (read-line)
      enc (zaszyfruj -1 text)]
  (print "Oryginalny :" text "\n")
  (print "Szyfrowanie :" enc "\n")
  (print "Odszyfrowanie:" (odszyfruj -1 enc) "\n")))

(przekon))