public class HillClimbing {
    public static final int ITERATIONS_BEFORE_MAXIMA = 100;
    public Route findShortestRoute(Route currentRoute) {
        Route adjacentRoute;
        int iterToMaximaCounter = 0;
        String compareRoutes = null;
        while (iterToMaximaCounter < ITERATIONS_BEFORE_MAXIMA) {
            adjacentRoute = obtainAdjacentRoute(new Route(currentRoute));
            if (adjacentRoute.getTotalDistance() <= currentRoute.getTotalDistance()) {
                compareRoutes = "<= (proceed)";
                iterToMaximaCounter = 0;
                currentRoute = new Route(adjacentRoute);
            }  else compareRoutes = "> (stay) - iteration # "+ iterToMaximaCounter++;
            System.out.println("       | " + compareRoutes);
            System.out.print(currentRoute + " |      " + currentRoute.getTotalStringDistance());
        }
        if (iterToMaximaCounter == 100) System.out.println("       | potential maxima");
        else System.out.println("     | " + compareRoutes);
        return currentRoute;
    }
    private Route obtainAdjacentRoute(Route route) {
        int x1 = 0, x2 = 0;
        while (x1 == x2) {
            x1 = (int) (route.getCities().size() * Math.random());
            x2 = (int) (route.getCities().size() * Math.random());
        }
        City city1 = route.getCities().get(x1);
        City city2 = route.getCities().get(x2);
        route.getCities().set(x2, city1);
        route.getCities().set(x1, city2);
        return route;
    }
}
