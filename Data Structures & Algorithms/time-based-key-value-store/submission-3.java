class TimeMap {

    private final Map<String, List<TimedValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimedValue> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(new TimedValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimedValue> values = map.get(key);
        if (values == null || values.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = values.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == 0) {
            return "";
        }

        return values.get(left - 1).value;
    }

    private static class TimedValue {
        final String value;
        final int timestamp;

        TimedValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
