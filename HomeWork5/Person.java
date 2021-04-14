package HomeWork5;

public class Person {

    public static void main(String[] args) {
       Worker[] empCorp = new Worker[5];
        empCorp[0] = new Worker("Bob", "Engineer", "Bob@mailbox.com", "427711", 50000, 42);
        empCorp[1] = new Worker("Petrov","manager","Petrob@mail.ru","434323",79999, 35);
        empCorp[2] = new Worker("Ivan", "Water pot", "Ivan@mailbox.com", "424204", 10000, 43);
        empCorp[3] = new Worker("Robert", "EnvelopeLicker", "Robert@mailbox.com", "424056", 5000, 19);
        empCorp[4] = new Worker("Jo", "GrinderPencil", "jo@mailbox.com", "752354", 6000, 21);
        for (Worker worker : empCorp)
            if (worker.getAge() > 40)
                System.out.println(worker);

    }
}
    class Worker {
        private String name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        public Worker(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return (name + "\n-"
                    + position + "\n-"
                    + email + "\n-"
                    + phone + "\n-"
                    + salary + "\n-"
                    + age);
        }


    }
