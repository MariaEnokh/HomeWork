package HomeWork6;

public class HomeWork5 {

    public static void main(String[] args) {

        String tempWinEvent = "это получилось";
        String tempLossEvent = "Это не получилось";
        String eventName;
        String eventResult;

        Cat cat = new Cat("пушок", 100, 2f);
        Dog dog = new Dog("Рекс", 500,10f);

        Animal[] arr = {cat, dog};
        float runLength = 100;
        float swimLength = 8;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";



            eventName = "пробежать на" + arr[i].getMaxRun() + " Пытается пробежать на ";
            eventResult = (arr[i].run(runLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);


            int swimResult = arr[i].swim(swimLength);
            eventName = " проплыть на " + arr[i].getMaxSwim() + " попытка проплыть на ";
            eventResult = (swimResult == Animal.SWIM_OK) ? tempWinEvent : tempLossEvent;

            if(swimResult == Animal.SWIM_NONE)
                eventResult = " это не получилось, потому что не умеет плавать ";
            result(nameString, eventName, swimLength, eventResult);

        }

    }
    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + "м  и" + resultEvent);
    }


}