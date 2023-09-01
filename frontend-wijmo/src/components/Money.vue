<template>

    <div>
        <div class="detail-title">
        Money
        </div>
        <v-col>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="Currency" v-model="value.currency" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Money',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'Money',
    }),
    props: {
        Editable: Boolean,
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
            this.Editable = false
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
        EditableClick(){
            if(this.editMode == true) {
                this.Editable = true
            }
        }
    }
}
</script>

