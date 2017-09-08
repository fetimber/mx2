package net.huimin.yk.web.model.customer;

import java.math.BigDecimal;

public class CustomerChoice {
    /**
     * 主键
     */
    private Integer id;

    private Integer ruleId;

    private String choiceName;

    private String choiceContent;

    private BigDecimal choiceScore;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public String getChoiceContent() {
        return choiceContent;
    }

    public void setChoiceContent(String choiceContent) {
        this.choiceContent = choiceContent;
    }

    public BigDecimal getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(BigDecimal choiceScore) {
        this.choiceScore = choiceScore;
    }
}