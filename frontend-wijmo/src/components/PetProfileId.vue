<template>
    <div>
        <BasePicker v-if="Editable" searchApiPath="petprofiles/search/findBy" searchParameterName=""  idField="id" nameField="" path="petprofiles" label="PetProfileId" v-model="value" @selected="pick" :editMode="editMode" />
        <div v-else style="height:100%" @click="EditableClick">
            <span>{{ value && value.name ? value.name : '' }}</span>
        </div>
    </div>

</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'PetProfileId',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'petprofiles',
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

