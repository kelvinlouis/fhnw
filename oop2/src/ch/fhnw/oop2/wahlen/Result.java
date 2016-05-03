package ch.fhnw.oop2.wahlen;

/**
 * the result of an election
 */
public class Result {

    private final String communityName;
    private final String canton;
    private final int eligibleVoters;
    private final int voters;
    private final float turnout;

    /**
     * creates a new Result
     *
     * @param communityName the name of the community
     * @param canton the canton of the community
     * @param eligibleVoters the number of eligible voters
     * @param voters the number of actual voters
     */
    public Result(String communityName, String canton,
            int eligibleVoters, int voters) {

        this.communityName = communityName;
        this.canton = canton;
        this.eligibleVoters = eligibleVoters;
        this.voters = voters;

        turnout = (float) voters / eligibleVoters;
    }

    /**
     * returns the name of the community
     *
     * @return the name of the community
     */
    public String getCommunityName() {
        return communityName;
    }

    /**
     * returns the canton of the community
     *
     * @return the canton of the community
     */
    public String getCanton() {
        return canton;
    }

    /**
     * returns the number of eligible voters
     *
     * @return the number of eligible voters
     */
    public int getEligibleVoters() {
        return eligibleVoters;
    }

    /**
     * returns the number of actual voters
     *
     * @return the number of actual voters
     */
    public int getVoters() {
        return voters;
    }

    /**
     * returns the turnout of voters
     *
     * @return the turnout of voters
     */
    public float getTurnout() {
        return turnout;
    }
}
