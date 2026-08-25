class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new int[] { position[i], speed[i] });
        }
        Collections.sort(cars, (a, b) -> a[0] - b[0]);

        int fleetCount = 1;
        float lastFleetTime = (float) (target - cars.get(n - 1)[0]) / cars.get(n - 1)[1];

        for (int i = n - 2; i >= 0; i--) {
            int[] currentCar = cars.get(i);
            int curPos = currentCar[0];
            int curSpeed = currentCar[1];

            float carTime = (float) (target - curPos) / curSpeed;

            if (carTime > lastFleetTime) {
                lastFleetTime = carTime;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
