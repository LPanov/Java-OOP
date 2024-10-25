package InterfaceAndAbstractionExercises.MilitaryElite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<SoldierImpl> soldiers = new LinkedList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");

            if (token[0].equals("Private")) {
                int id = Integer.parseInt(token[1]);
                String firstName = token[2];
                String lastName = token[3];
                double salary = Double.parseDouble(token[4]);

                PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                soldiers.add(priv);
            }
            else if (token[0].equals("LieutenantGeneral")) {
                int id = Integer.parseInt(token[1]);
                String firstName = token[2];
                String lastName = token[3];
                double salary = Double.parseDouble(token[4]);

                LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                for (int i = 5; i < token.length; i++) {
                    int idPrivate = Integer.parseInt(token[i]);
                    PrivateImpl priv = (PrivateImpl) soldiers.stream().filter(pr -> pr.getId() == idPrivate).collect(Collectors.toList()).getFirst();
                    lieutenantGeneral.addPrivate(priv);
                }

                soldiers.add(lieutenantGeneral);
            }
            else if (token[0].equals("Engineer")) {
                int id = Integer.parseInt(token[1]);
                String firstName = token[2];
                String lastName = token[3];
                double salary = Double.parseDouble(token[4]);

                try {
                    Corps corps = Corps.valueOf(token[5]);

                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                    for (int i = 6; i < token.length; i+=2) {
                        String partName = token[i];
                        int hours = Integer.parseInt(token[i+1]);

                        Repair repair = new Repair(partName, hours);
                        engineer.addRepair(repair);
                    }
                    soldiers.add(engineer);
                }
                catch (IllegalArgumentException e) {}

            }
            else if (token[0].equals("Commando")) {
                int id = Integer.parseInt(token[1]);
                String firstName = token[2];
                String lastName = token[3];
                double salary = Double.parseDouble(token[4]);
                try {
                    Corps corps = Corps.valueOf(token[5]);

                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);

                    for (int i = 6; i < token.length; i+=2) {
                        String missionCodeName = token[i];
                        try {
                            State state = State.valueOf(token[i+1]);

                            Mission mission = new Mission(missionCodeName, state);
                            commando.addMission(mission);
                        } catch (IllegalArgumentException e) {}
                    }
                    soldiers.add(commando);
                } catch (IllegalArgumentException e) {}

            }
            else if (token[0].equals("Spy")) {
                int id = Integer.parseInt(token[1]);
                String firstName = token[2];
                String lastName = token[3];
                String codeNumber = token[4];

                SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                soldiers.add(spy);
            }

            command = scanner.nextLine();
        }

        soldiers.forEach(System.out::println);
    }
}
