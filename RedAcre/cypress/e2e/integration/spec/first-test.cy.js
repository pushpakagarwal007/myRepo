import { selector } from '../../support/elements/selectors.js';

describe('Get the earlist flight price', () => {

  const dd_way_picker = '.km-select-picker>.select-input.input-holder>input[value="Round trip"]';
  const btn_one_way = '.km-select-picker>.input-drop-container.select-option-container>.select-option.ellipsis[role="button"]';
  const txt_today_day = '.DayPicker-Months>.DayPicker-Month>.DayPicker-Body>.DayPicker-Week>.DayPicker-Day.DayPicker-Day--today';
  const btn_find_flights = '.input-holder.buttons>.btn.btn-primary.btn-lg.d-none.d-md-block';

  it('Find the First Available Flight Price', () => {
      cy.visit(selector.website);
      cy.get(selector.lg_white_logo).should('be.visible');
      cy.get(selector.btn_cookie).click();

      Cypress.on('uncaught:exception', (err, runnable) => {
        return false
      })
      
      cy.get(dd_way_picker).click();
      cy.get(btn_one_way).eq(1).should('have.text',"One way").click();
      cy.get(selector.cnt_departing_from).find(selector.inp_airport).find('label').should('have.text',"Departing from")
      cy.get(selector.cnt_departing_from).find(selector.inp_airport).find(selector.txtb_input_airport).type('Vienna International');
      cy.get(selector.cnt_departing_from).find(selector.dd_select_airport).should('have.text',"Vienna International").click();
      cy.get(selector.cnt_flying_to).find(selector.inp_airport).find(selector.txtb_input_airport).type('Malta International Airport');
      cy.get(selector.cnt_flying_to).find(selector.dd_select_airport).should('have.text',"Malta International Airport").click();
      cy.get(selector.dp_one_way).click();
      cy.get(txt_today_day).click();
      cy.get(btn_find_flights).should('have.text',"Find flights").click();
      cy.get(selector.lnk_flexible_dates).should('be.visible');
      cy.get(selector.lnk_flexible_dates).click();
      const price = cy.get(selector.cnt_earlist_flight).find(selector.bx_earlist_flight).should('be.visible').eq(0).find(selector.txt_price).invoke('text').then
      (
        tempPrice => { let price = tempPrice; 
          cy.log("===== Price of the earliest available flight ==== € "+price);
        }
      );
  })
})