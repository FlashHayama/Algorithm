from game import Directions, Actions
import util


class SearchProblem:
    def __init__(self, game_state, goal, start=None):
        self.game_state = game_state
        self.walls = game_state.getWalls()
        self.start_state = game_state.getPacmanPosition()
        if start is not None:
            self.start_state = start
        self.goal = goal

    def is_goal_state(self, state):
        return self.goal(state)

    def get_successors(self, state):
        successors = []
        for action in [Directions.NORTH, Directions.SOUTH,
                       Directions.EAST, Directions.WEST]:
            x, y = state
            dx, dy = Actions.directionToVector(action)
            nextx, nexty = int(x + dx), int(y + dy)
            if not self.walls[nextx][nexty]:
                nextState = (nextx, nexty)
                successors.append((nextState, action, 1))
        return successors


class GoalNotFound(Exception):
    pass


class Node:
    def __init__(self, state, parent=None, action=None, step_cost=0):
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = step_cost
        if parent is not None:
            self.path_cost += parent.path_cost

    def child_node(self, state, action, step_cost):
        return Node(state, self, action, step_cost)

    def __eq__(self, other):
        if isinstance(other, Node):
            return self.state.__eq__(other.state)
        else:
            return NotImplemented

    def __hash__(self):
        return hash(self.state)

    def solution(self):
        if self.parent is None:
            return []
        else:
            return self.parent.solution() + [self.action]


class PrioFrontier(util.PriorityQueue):
    def __init__(self, priority_function):
        super().__init__()
        self.priority_function = priority_function

    def update(self, node):
        super().update(node, self.priority_function(node))


def graph_search(problem, frontier):
    frontier.update(Node(problem.start_state))

    explored = set()

    while not frontier.isEmpty():
        node = frontier.pop()
        if problem.is_goal_state(node.state):
            return node.solution()
        explored.add(node.state)
        for transition in problem.get_successors(node.state):
            child_node = node.child_node(*transition)
            if child_node.state not in explored:
                frontier.update(child_node)
    raise GoalNotFound()


def aStarSearch(problem, heuristic):
    def prio(node):
        return node.path_cost + heuristic(node.state, problem)
    frontier = PrioFrontier(prio)
    return graph_search(problem, frontier)


def null_heuristic(_pos, _prob):
    return 0


def goal_distance(game_state, goal, start=None, heuristic=null_heuristic):
    """
    Return the distance to the closest "goal".

    The underlying search algorithm is an A* search.

    goal is function such that goal(position) returns true iff the given
    position is a goal.
    start is a position (x, y) (default is Pacman's position).
    heuristic(position, problem) is a heuristic function taking a position and
    problem as input (default heuristic is the trivial null heuristic,
    effectively searching using a BFS).
    """
    return len(aStarSearch(SearchProblem(game_state, goal, start), heuristic))


def food_distance(game_state, start=None):
    """
    Return the distance to the closest food.

    start is a position (x, y) (default is Pacman's position).
    """
    return goal_distance(
            game_state,
            lambda pos: game_state.hasFood(*pos),
            start=start)


def maze_distance(game_state, destination, start=None):
    """
    Return the distance to some destination.

    start and destination are positions (x, y). By default, start is Pacman's
    position.
    """
    return goal_distance(
            game_state,
            lambda pos: util.manhattanDistance(pos, destination) < 1.,
            start=start,
            heuristic=lambda pos, _: util.manhattanDistance(pos, destination))
