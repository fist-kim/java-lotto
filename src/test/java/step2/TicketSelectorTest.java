package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.TicketSelector;

import static org.assertj.core.api.Assertions.*;

class TicketSelectorTest {

    private TicketSelector ticketSelector = new TicketSelector();

    @DisplayName("1 ~ 45 에 대한 정해진 로또 번호들을 담은 컬렉션이 생성 되는지 테스트")
    @Test
    void getLottoNumbersTest(){
        assertThat(ticketSelector.getLottoNumbers().size()).isEqualTo(45);
    }

    @DisplayName("입력받은 총액에 따라 가능한 로또 횟수 계산 테스트")
    @Test
    void calculateAvailableCountTest(){
        int amount = 14900;
        assertThat(ticketSelector.calculateAvailableCount(amount)).isEqualTo(14);
    }

    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 원하는 갯수 만큼 생성 되는지 테스트")
    @Test
    void buySingleLottoTicket(){
        LottoTicket lottoTicket = ticketSelector.buySingleLottoTicket();
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 티켓 한 장 구매시 로또 번호가 랜덤하게 생성 되는지 테스트")
    @Test
    void buySingleLottoTicketRandomTest(){
        LottoTicket firstLottoTicket = ticketSelector.buySingleLottoTicket();
        LottoTicket secondLottoTicket = ticketSelector.buySingleLottoTicket();

        assertThat(firstLottoTicket.getNumbers().equals(secondLottoTicket.getNumbers())).isFalse();
    }

    @DisplayName("주어진 금액 내에서 최대치의 로또 티켓이 구매 되는지 테스트")
    @Test
    void buyAvailableLottoTicketsTest(){
        ticketSelector.buyAvailableLottoTickets(ticketSelector.calculateAvailableCount(14900));
        assertThat(ticketSelector.getLottoTickets().size()).isEqualTo(14);
    }

}
