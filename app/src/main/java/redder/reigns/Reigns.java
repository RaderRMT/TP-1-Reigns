package redder.reigns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Reigns {

    private final List<Question> questions;

    private Personnage personnage;

    private Reigns() {
        this.questions = new ArrayList<>();
    }

    private void start() {
        // début du jeu
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();

        System.out.println(this.personnage.getGenre().longRegne()
                + " " + this.personnage.getNom());

        this.personnage.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while (!this.personnage.finDuJeu()) {
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            this.personnage.AfficheJauges();
        }

        // fin du jeu
        System.out.println(
                this.personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        + nbTours
                        + " tours");
    }

    private void reponseQuestion(Question question) {
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffetsGauche(this.personnage);
        }else{
            question.appliqueEffetsDroite(this.personnage);
        }
    }

    private void initPersonnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine;
        if(genre==1){
            roiReine = Genre.ROI;
        }else{
            roiReine = Genre.REINE;
        }

        this.personnage = new Personnage(nom,roiReine);
    }

    private void initBanqueQuestions() {
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        this.questions.add(question1);

        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        this.questions.add(question2);

        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        this.questions.add(question3);

        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        this.questions.add(question4);

        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        this.questions.add(question5);
    }

    private Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*this.questions.size());
        return this.questions.get(numQuestion);
    }

    public static void main(String[] args) {
        Reigns reigns = new Reigns();
        reigns.start();
    }
}
