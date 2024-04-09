//import java.util.LinkedList;
//import java.util.Queue;
//
//class enum Direction {
//    UP, DOWN, NONE
//}
//
//class Request {
//    public int floor;
//    public Direction direction;
//}
//
//class Lift {
//    private boolean [] floors;
//    private Direction direction;
//    private Queue<Request> pendingRequests = new LinkedList<>();
//
//
//    public Lift(int floors) {
//        floors = new boolean[5];
//        this.direction = Direction.NONE;
//    }
//
//    public void acceptRequest(Request request){
//        if (request.direction != this.direction or missingDirection() {
//            pendingRequests.add(request);
//        } else {
//            if (this.direction == NONE) {
//                this.direction = request.direction;
//            }
//            floors[request.floor] = true;
//        }
//    }
////
//
//    public void runLift() {
//        if (direction == Direction.NONE) {
//
//        }
//        int nextFloor = getNextFloor();
//        if (nextFloor == -1 ){
//            processPendingRequests();
//        }
//        while (this.getCurrentFloor() != getNextFloor()) {
//            System.out.println("Lift is moving to floor " + nextFloor);
//        }
//        if (nextFloor == floors.size()) {
//            direction = Direction.DOWN;
//            processPendingRequests()
//        } else if (nextFloor == 0) {
//            direction = Direction.UP;
//            processPendingRequests();
//        }
////        manageDoor();
//        floors[nextFloor] = false;
//        runLift();
//    }
//
//    private int getNextFloor() {
//        if (direction == Direction.UP) {
//            for (int i = getCurrentFloor()+1; i < floors.length; i++) {
//                if (floors[i]) {
//                    return i;
//                }
//            }
//        } else if (direction == Direction.DOWN) {
//            for (int i = getCurrentFloor()-1; i >= 0; i--) {
//                if (floors[i]) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    private int getCurrentFloor() {
//
//    }
//
//    private void processPendingRequests() {
//        int size = pendingRequests.size();
//        while (size -- > 0) {
//            Request request = pendingRequests.poll();
//            if request.direction == this.direction {
//                floors[request.floor] = true;
//            } else {
//                request.offer(request);
//            }
//        }
//    }
//}
public class LiftTest {
}
