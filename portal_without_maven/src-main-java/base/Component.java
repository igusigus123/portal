package base;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Component {

	WebDriver driver;

	public Component(WebDriver driver) {
		this.driver = driver;
	}

	private static String creditAmount;
	private static String propertyValue;
	private static String typeCredit;
	private static String installmentsCount;
	private static String installmentsValue;
	private static String creditChance;
	private static boolean calculationBefore;
	private static Date startCountDate;
	private static String calculationTime;
	private static String sourceOfIncome;
	private static String sourceOfIncome2;
	private static String monthIncome;
	private static String monthIncome2;
	private static String legalCharges;
	private static String legalCharges2;
	private static String payedInstallments;
	private static String payedInstallments2;
	private static String creditLimits;
	private static String creditLimits2;
	private static String dependents;
	private static String houeseholdExpenses;
	private static String tooltipAmount;
	private static String tooltipHowToPay;
	private static String sourceOfIncomeTooltip;
	private static String monthIncomeTooltip;
	private static String legalChargesTooltip;
	private static String dependentsTooltip;
	private static String householdExpensesTooltip;
	private static String scoreTooltip;
	private static String punctualityPaymentTooltip;
	private static String scoringTooltip;
	private static String budgetChargeTooltip;
	private static String creditSumTooltip;
	private static String propertyValueTooltip;
	private static String creditTakerTooltip;
	private static String creditTaker;
	private static String environment;
	
	public static String getCreditTaker() {
		return creditTaker;
	}
	public static void setCreditTaker(String creditTaker) {
		Component.creditTaker = creditTaker;
	}
	public static String getCreditTakerTooltip() {
		return creditTakerTooltip;
	}
	public static void setCreditTakerTooltip(String creditTakerTooltip) {
		Component.creditTakerTooltip = creditTakerTooltip;
	}
	public static String getPropertyValue() {
		return propertyValue;
	}
	public static void setPropertyValue(String propertyValue) {
		Component.propertyValue = propertyValue;
	}
	public static String getPropertyValueTooltip() {
		return propertyValueTooltip;
	}
	public static void setPropertyValueTooltip(String propertyValueTooltip) {
		Component.propertyValueTooltip = propertyValueTooltip;
	}
	public static String getCalculationTime() {
		return calculationTime;
	}
	public static void setCalculationTime(String calculationTime) {
		Component.calculationTime = calculationTime;
	}
	public static String getSourceOfIncome() {
		return sourceOfIncome;
	}
	public static void setSourceOfIncome(String sourceOfIncome) {
		Component.sourceOfIncome = sourceOfIncome;
	}
	public static String getMonthIncome() {
		return monthIncome;
	}
	public static void setMonthIncome(String monthIncome) {
		Component.monthIncome = monthIncome;
	}
	public static String getLegalCharges() {
		return legalCharges;
	}
	public static void setLegalCharges(String legalCharges) {
		Component.legalCharges = legalCharges;
	}
	public static String getPayedInstallments() {
		return payedInstallments;
	}
	public static void setPayedInstallments(String payedInstallments) {
		Component.payedInstallments = payedInstallments;
	}
	public static String getCreditLimits() {
		return creditLimits;
	}
	public static void setCreditLimits(String creditLimits) {
		Component.creditLimits = creditLimits;
	}
	public static String getDependents() {
		return dependents;
	}
	public static void setDependents(String dependents) {
		Component.dependents = dependents;
	}
	public static String getHoueseholdExpenses() {
		return houeseholdExpenses;
	}
	public static void setHoueseholdExpenses(String houeseholdExpenses) {
		Component.houeseholdExpenses = houeseholdExpenses;
	}
	public static String getTooltipAmount() {
		return tooltipAmount;
	}
	public static void setTooltipAmount(String tooltipAmount) {
		Component.tooltipAmount = tooltipAmount;
	}
	public static String getTooltipHowToPay() {
		return tooltipHowToPay;
	}
	public static void setTooltipHowToPay(String tooltipHowToPay) {
		Component.tooltipHowToPay = tooltipHowToPay;
	}
	public static String getSourceOfIncomeTooltip() {
		return sourceOfIncomeTooltip;
	}
	public static void setSourceOfIncomeTooltip(String sourceOfIncomeTooltip) {
		Component.sourceOfIncomeTooltip = sourceOfIncomeTooltip;
	}
	public static String getMonthIncomeTooltip() {
		return monthIncomeTooltip;
	}
	public static void setMonthIncomeTooltip(String monthIncomeTooltip) {
		Component.monthIncomeTooltip = monthIncomeTooltip;
	}
	public static String getLegalChargesTooltip() {
		return legalChargesTooltip;
	}
	public static void setLegalChargesTooltip(String legalChargesTooltip) {
		Component.legalChargesTooltip = legalChargesTooltip;
	}
	public static String getDependentsTooltip() {
		return dependentsTooltip;
	}
	public static void setDependentsTooltip(String dependentsTooltip) {
		Component.dependentsTooltip = dependentsTooltip;
	}
	public static String getHouseholdExpensesTooltip() {
		return householdExpensesTooltip;
	}
	public static void setHouseholdExpensesTooltip(String householdExpensesTooltip) {
		Component.householdExpensesTooltip = householdExpensesTooltip;
	}
	public static String getScoreTooltip() {
		return scoreTooltip;
	}
	public static void setScoreTooltip(String scoreTooltip) {
		Component.scoreTooltip = scoreTooltip;
	}
	public static String getPunctualityPaymentTooltip() {
		return punctualityPaymentTooltip;
	}
	public static void setPunctualityPaymentTooltip(String punctualityPaymentTooltip) {
		Component.punctualityPaymentTooltip = punctualityPaymentTooltip;
	}
	public static String getScoringTooltip() {
		return scoringTooltip;
	}
	public static void setScoringTooltip(String scoringTooltip) {
		Component.scoringTooltip = scoringTooltip;
	}
	public static String getBudgetChargeTooltip() {
		return budgetChargeTooltip;
	}
	public static void setBudgetChargeTooltip(String budgetChargeTooltip) {
		Component.budgetChargeTooltip = budgetChargeTooltip;
	}
	public static String getCreditSumTooltip() {
		return creditSumTooltip;
	}
	public static void setCreditSumTooltip(String creditSumTooltip) {
		Component.creditSumTooltip = creditSumTooltip;
	}
	public static Date getStartCountDate() {
		return startCountDate;
	}
	public static void setStartCountDate(Date startCountDate) {
		Component.startCountDate = startCountDate;
	}
	public boolean isCalculationBefore() {
		return calculationBefore;
	}
	public void setCalculationBefore(boolean calculationBefore) {
		this.calculationBefore = calculationBefore;
	}
	public String getCreditChance() {
		return creditChance;
	}
	public void setCreditChance(String creditChance) {
		this.creditChance = creditChance;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getTypeCredit() {
		return typeCredit;
	}
	public void setTypeCredit(String typeCredit) {
		this.typeCredit = typeCredit;
	}
	public String getInstallmentsCount() {
		return installmentsCount;
	}
	public void setInstallmentsCount(String installmentsCount) {
		this.installmentsCount = installmentsCount;
	}
	public String getInstallmentsValue() {
		return installmentsValue;
	}
	public void setInstallmentsValue(String installmentsValue) {
		this.installmentsValue = installmentsValue;
	}
	public static String getEnvironment() {
		return environment;
	}
	public static void setEnvironment(String environment) {
		Component.environment = environment;
	}
	public static String getSourceOfIncome2() {
		return sourceOfIncome2;
	}
	public static void setSourceOfIncome2(String sourceOfIncome2) {
		Component.sourceOfIncome2 = sourceOfIncome2;
	}
	public static String getMonthIncome2() {
		return monthIncome2;
	}
	public static void setMonthIncome2(String monthIncome2) {
		Component.monthIncome2 = monthIncome2;
	}
	public static String getLegalCharges2() {
		return legalCharges2;
	}
	public static void setLegalCharges2(String legalCharges2) {
		Component.legalCharges2 = legalCharges2;
	}
	public static String getPayedInstallments2() {
		return payedInstallments2;
	}
	public static void setPayedInstallments2(String payedInstallments2) {
		Component.payedInstallments2 = payedInstallments2;
	}
	public static String getCreditLimits2() {
		return creditLimits2;
	}
	public static void setCreditLimits2(String creditLimits2) {
		Component.creditLimits2 = creditLimits2;
	}

}
