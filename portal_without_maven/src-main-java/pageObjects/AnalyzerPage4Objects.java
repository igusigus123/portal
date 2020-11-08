package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalyzerPage4Objects {
	WebDriver driver;
	WebDriverWait w;

	public AnalyzerPage4Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 5);
	}

	// chanceText
	@FindBy(xpath = "//h3[@class='mt-10']//strong")
	private WebElement chanceText;

	public WebElement chanceText() {
		w.until(ExpectedConditions.visibilityOf(chanceText));
		return chanceText;
	}

	// caclucationDate
	@FindBy(xpath = "//div[@class='col-xs-12 col-md-6 hidden-sm hidden-xs text-right']//h3")
	private WebElement caclucationDate;

	public WebElement caclucationDate() {
		w.until(ExpectedConditions.visibilityOf(caclucationDate));
		return caclucationDate;
	}

	// iconMarker
	@FindBy(xpath = "//img[@class='max-width-185']")
	private WebElement iconMarker;

	public WebElement iconMarker() {
		w.until(ExpectedConditions.visibilityOf(iconMarker));
		return iconMarker;
	}

	// scoreTooltip
	@FindBy(xpath = "//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement scoreTooltip;

	public WebElement scoreTooltip() {
		w.until(ExpectedConditions.visibilityOf(scoreTooltip));
		return scoreTooltip;
	}

	// scoreTooltipText
	@FindBy(xpath = "//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[1]")
	private WebElement scoreTooltipText;

	public WebElement scoreTooltipText() {
		w.until(ExpectedConditions.visibilityOf(scoreTooltipText));
		return scoreTooltipText;
	}

	// summaryCreditType
	@FindBy(xpath = "//div[@class='pt-30 pb-30 pr-20 pl-20 pr-xs-0 pl-xs-0']//div[1]//strong[1]")
	private WebElement summaryCreditType;

	public WebElement summaryCreditType() {
		w.until(ExpectedConditions.visibilityOf(summaryCreditType));
		return summaryCreditType;
	}

	// summaryCreditAmount
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 dotted-border-col']//div[2]//strong[1]")
	private WebElement summaryCreditAmount;

	public WebElement summaryCreditAmount() {
		w.until(ExpectedConditions.visibilityOf(summaryCreditAmount));
		return summaryCreditAmount;
	}

	// summaryInstallmentsCount
	@FindBy(xpath = "//div[3]//strong[1]")
	private WebElement summaryInstallmentsCount;

	public WebElement summaryInstallmentsCount() {
		w.until(ExpectedConditions.visibilityOf(summaryInstallmentsCount));
		return summaryInstallmentsCount;
	}

	// summaryInstallmentsValue
	@FindBy(xpath = "//div[@id='ux-desktop']//div[4]//strong[1]")
	private WebElement summaryInstallmentsValue;

	public WebElement summaryInstallmentsValue() {
		w.until(ExpectedConditions.visibilityOf(summaryInstallmentsValue));
		return summaryInstallmentsValue;
	}

	// punctualityPaymentTooltip
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement punctualityPaymentTooltip;

	public WebElement punctualityPaymentTooltip() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentTooltip));
		return punctualityPaymentTooltip;
	}

	// punctualityPaymentTooltipText
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement punctualityPaymentTooltipText;

	public WebElement punctualityPaymentTooltipText() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentTooltip));
		return punctualityPaymentTooltipText;
	}

	// punctualityPaymentSeeMore
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement punctualityPaymentSeeMore;

	public WebElement punctualityPaymentSeeMore() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentSeeMore));
		return punctualityPaymentSeeMore;
	}

	// punctualityPaymentSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//a[@class='mr-20']")
	private WebElement punctualityPaymentSeeLess;

	public WebElement punctualityPaymentSeeLess() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentSeeLess));
		return punctualityPaymentSeeLess;
	}

	// scoringTooltip
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement scoringTooltip;

	public WebElement scoringTooltip() {
		w.until(ExpectedConditions.visibilityOf(scoringTooltip));
		return scoringTooltip;
	}

	// scoringTooltipText
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement scoringTooltipText;

	public WebElement scoringTooltipText() {
		w.until(ExpectedConditions.visibilityOf(scoringTooltipText));
		return scoringTooltipText;
	}

	// scoringSeeMore
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement scoringSeeMore;

	public WebElement scoringSeeMore() {
		w.until(ExpectedConditions.visibilityOf(scoringSeeMore));
		return scoringSeeMore;
	}

	// scoringSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//div[@class='text-right mt-30 analyzer-hide-details-anchor']//span")
	private WebElement scoringSeeLess;

	public WebElement scoringSeeLess() {
		w.until(ExpectedConditions.visibilityOf(scoringSeeLess));
		return scoringSeeLess;
	}

	// budgetChargeTooltip
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement budgetChargeTooltip;

	public WebElement budgetChargeTooltip() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeTooltip));
		return budgetChargeTooltip;
	}

	// budgetChargeTooltipText
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement budgetChargeTooltipText;

	public WebElement budgetChargeTooltipText() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeTooltipText));
		return budgetChargeTooltipText;
	}

	// budgetChargeSeeMore
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement budgetChargeSeeMore;

	public WebElement budgetChargeSeeMore() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeSeeMore));
		return budgetChargeSeeMore;
	}

	// budgetChargeSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//span")
	private WebElement budgetChargeSeeLess;

	public WebElement budgetChargeSeeLess() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeSeeLess));
		return budgetChargeSeeLess;
	}

	// creditSumTooltip
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement creditSumTooltip;

	public WebElement creditSumTooltip() {
		w.until(ExpectedConditions.visibilityOf(creditSumTooltip));
		return creditSumTooltip;
	}

	// creditSumTooltipText
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement creditSumTooltipText;

	public WebElement creditSumTooltipText() {
		w.until(ExpectedConditions.visibilityOf(creditSumTooltipText));
		return creditSumTooltipText;
	}

	// creditSumSeeMore
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement creditSumSeeMore;

	public WebElement creditSumSeeMore() {
		w.until(ExpectedConditions.visibilityOf(creditSumSeeMore));
		return creditSumSeeMore;
	}

	// creditSumSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//div[@class='text-right mt-30 analyzer-hide-details-anchor']//span")
	private WebElement creditSumSeeLess;

	public WebElement creditSumSeeLess() {
		w.until(ExpectedConditions.visibilityOf(creditSumSeeLess));
		return creditSumSeeLess;
	}

	// calculateAnotherCredit
	@FindBy(xpath = "//div[@class='col-lg-10 col-md-9 col-sm-8 col-xs-12 pt-15 pt-xs-0 pull-right']//a")
	private WebElement calculateAnotherCredit;

	public WebElement calculateAnotherCredit() {
		w.until(ExpectedConditions.visibilityOf(calculateAnotherCredit));
		return calculateAnotherCredit;
	}

	// toHomePage
	@FindBy(xpath = "//a[@class='outline-button w-xs-100']")
	private WebElement toHomePage;

	public WebElement toHomePage() {
		w.until(ExpectedConditions.visibilityOf(toHomePage));
		return toHomePage;
	}
}
