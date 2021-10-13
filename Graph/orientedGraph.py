class OrientedGraph:

    def __init__(self, head, succ):
        self.hsucc = head
        self.succ = succ
        self.hpred = []
        self.pred = []
        self.inDeg = self.write_inDeg()
        self.outDeg = []

    def write_inDeg(self):
        #Recherche du nombre de predecesseur par noeud
        inDeg = [0] * len(self.hsucc)

        for s in self.succ:
            inDeg[s] += 1
        
        return inDeg

    def write_outDeg(self):
        if len(self.hpred) <= 0:
            return
        outDeg = [0] * len(self.hpred)
        for p in self.pred:
            outDeg[p] += 1

        return outDeg
    
    def find_pred(self):
        #Conversion des liste successeur en liste predecesseur
        self.hpred = [0]
        tempH = []
        tempPred = [0] * sum(self.inDeg)
        
        for np in range(len(self.inDeg) - 1):
            self.hpred.append(self.hpred[np] + self.inDeg[np])
            tempH.append(self.hpred[np] + self.inDeg[np])

        for h in range(len(self.hsucc) - 1):
            for s in range(self.hsucc[h],self.hsucc[h + 1]):
                tempH[self.succ[s]] -= 1
                tempPred[tempH[self.succ[s]]] = h
        self.pred = tempPred
        self.outDeg = self.write_outDeg()

    def get_graph_put_in_level(self):
        # retourne une liste avec les sommets mis a niveau
        inDeg = self.inDeg[:]
        newSummits = []
        q = []
        for x in range(len(inDeg) - 1):
            if inDeg[x] == 0:
                q.append(x)
        while len(q) > 0:
            x = q[0]
            q.remove(x)
            newSummits.append(x)
            for k in range(self.hsucc[x], self.hsucc[x + 1]):
                y = self.succ[k]
                inDeg[y] -= 1
                if inDeg[y] == 0:
                    q.append(y)
        return newSummits

    def put_graph_in_level(self):
        level = self.get_graph_put_in_level()
        tempHead = []
        tempSucc = []
        iteration = 0

        for l in range(len(level)):
            tempHead.append(iteration)
            for s in range(self.hsucc[level[l]], self.hsucc[level[l] + 1]):
                tempSucc.append(level[self.succ[s]])
                iteration += 1
        tempHead.append(iteration)
        self.hsucc = tempHead
        self.succ = tempSucc
        self.inDeg = self.write_inDeg()
        self.find_pred()

    def search_bfs(self,summit):
        #Recherche en largeur des sommets accessible via <<summit>>, File
        if (len(self.hsucc) <= summit):     #\
            print("Summit is not exist")    # Voie si le sommet exist. Si non arrête 
            return                          #/
        mark = [False] * len(self.hsucc)    # Liste marquant les sommet déjà visité
        mark[summit] = True # Marque déjà le sommet choisi à True
        z = []  # Liste permettant de voire à quel sommet nous en somme
        z.append(summit)
        sSummits = [summit] # sauvegarde les noeud trouvé
        while len(z) > 0: # Boucle tant que des nouveaux sommets sont trouvé
            x = z[0]
            z.remove(x)
            for y in self.succ[self.hsucc[x]:self.hsucc[x+1]] : # Boucle sur les successeur d'un sommet trouvé
                if not mark[y]: # Marque un sommet et l'ajoute à <<z>> s'il n'est pas encore marqué
                    mark[y] = True
                    z.append(y)
                    sSummits.append(y)
        return sSummits

    def search_dfs(self,summit):
        #Recherche en profondeur des sommets accessible via <<summit>>, Pile
        if (len(self.hsucc) <= summit):     #\
            print("Summit is not exist")    # Voie si le sommet exist. Si non arrête 
            return                          #/
        mark = [False] * len(self.hsucc)    # Liste marquant les sommet déjà visité
        mark[summit] = True
        z = []  # Pile permettant de voire à quel sommet nous en somme
        z.append(summit)
        next = self.hsucc[:]
        sSummits = [summit]
        while len(z) > 0:
            x = z[-1]
            if next[x] >= self.hsucc[x+1]:
                z.pop()
            else:
                y = self.succ[next[x]]
                next[x] = next[x] + 1
                if not mark[y]:
                    mark[y] = True
                    z.append(y)
                    sSummits.append(y)
        return sSummits

    def __str__(self) -> str:
        string = "HEAD SUCC\t : " + str(self.hsucc)
        string += "\nSuccessor\t : " + str(self.succ)
        string += "\nHEAD PRED\t : " + str(self.hpred)
        string += "\nPredecessor\t : " + str(self.pred)
        string += "\nd-()\t\t : " + str(self.inDeg)
        string += "\nd+()\t\t : " + str(self.outDeg)
        return string

g = OrientedGraph([0,2,2,4,7,8,8,9,11],[1,7,1,6,2,4,5,5,5,2,6])
g.find_pred()
print(g)
#print(g.search_bfs(0))
#print(g.search_dfs(0))
#print(g.get_graph_put_in_level())
g.put_graph_in_level()
print("-----------------------\nAprès une mise à niveau:\n-----------------------")
print(g)
