<template>

    <div>
        <div class="detail-title">
        Money
        </div>

        <v-row style="padding-right:15px;">
            <v-col cols="6">
                <div style="display:flex;">
                    <div class="label-title">Amount</div>
                    <Number label="입력하세요." v-model="value.amount" :editMode="editMode"/>
                </div>
            </v-col>
            <v-col cols="6">
                <div style="display:flex;">
                    <div class="label-title">Currency</div>
                    <String label="입력하세요." v-model="value.currency" :editMode="editMode"/>
                </div>
            </v-col>
        </v-row>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
    export default {
        name: 'Money',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'amount': '',
                    'currency': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('amount' in this.value)) {
                    this.value.amount = 0;
                }
                if(!('currency' in this.value)) {
                    this.value.currency = '';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

