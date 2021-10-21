import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class PartsView extends PolymerElement {
    // language=HTML
    static get template() {
        return html`
            <vaadin-grid id="partsGrid"></vaadin-grid>
        `;
    }

    static get is() {
        return 'parts-view'
    }

    static get properties() {
        return {};
    }
}

customElements.define(PartsView.is, PartsView);
