<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='guahaorenyuan'"  label='挂号人员姓名' prop="guahaorenyuanName">
               <el-input v-model="ruleForm.guahaorenyuanName"  placeholder='挂号人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='guahaorenyuan'"  label='挂号人员手机号' prop="guahaorenyuanPhone">
               <el-input v-model="ruleForm.guahaorenyuanPhone"  placeholder='挂号人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='guahaorenyuan'"  label='挂号人员身份证号' prop="guahaorenyuanIdNumber">
               <el-input v-model="ruleForm.guahaorenyuanIdNumber"  placeholder='挂号人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='guahaorenyuan'" label='挂号人员头像' prop="guahaorenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.guahaorenyuanPhoto?ruleForm.guahaorenyuanPhoto:''"
                         @change="guahaorenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='huajiarenyuan'"  label='划价人员姓名' prop="huajiarenyuanName">
               <el-input v-model="ruleForm.huajiarenyuanName"  placeholder='划价人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huajiarenyuan'"  label='划价人员手机号' prop="huajiarenyuanPhone">
               <el-input v-model="ruleForm.huajiarenyuanPhone"  placeholder='划价人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huajiarenyuan'"  label='划价人员身份证号' prop="huajiarenyuanIdNumber">
               <el-input v-model="ruleForm.huajiarenyuanIdNumber"  placeholder='划价人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='huajiarenyuan'" label='划价人员头像' prop="huajiarenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.huajiarenyuanPhoto?ruleForm.huajiarenyuanPhoto:''"
                         @change="huajiarenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='医生姓名' prop="yishengName">
               <el-input v-model="ruleForm.yishengName"  placeholder='医生姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='医生联系方式' prop="yishengPhone">
               <el-input v-model="ruleForm.yishengPhone"  placeholder='医生联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'" label='医生头像' prop="yishengPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yishengPhoto?ruleForm.yishengPhoto:''"
                         @change="yishengPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'"  label='科室' prop="keshiTypes">
                 <el-select v-model="ruleForm.keshiTypes"  placeholder='请选择科室'>
                     <el-option
                             v-for="(item,index) in keshiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'"  label='职位' prop="zhiweiTypes">
                 <el-select v-model="ruleForm.zhiweiTypes" disabled  placeholder='请选择职位'>
                     <el-option
                             v-for="(item,index) in zhiweiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='挂号费' prop="guahaofei">
               <el-input v-model="ruleForm.guahaofei"  placeholder='挂号费' disabled clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' && flag!='shangjia'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
     keshiTypesOptions : [],
     zhiweiTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=keshi_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.keshiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhiwei_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.zhiweiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    guahaorenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.guahaorenyuanPhoto = fileUrls;
    },
    huajiarenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.huajiarenyuanPhoto = fileUrls;
    },
    yishengPhotoUploadChange(fileUrls) {
        this.ruleForm.yishengPhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.guahaorenyuanName)&& 'guahaorenyuan'==this.flag){
                             this.$message.error('挂号人员姓名不能为空');
                             return
                         }

                             if( 'guahaorenyuan' ==this.flag && this.ruleForm.guahaorenyuanPhone&&(!isMobile(this.ruleForm.guahaorenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.guahaorenyuanIdNumber)&& 'guahaorenyuan'==this.flag){
                             this.$message.error('挂号人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.guahaorenyuanPhoto)&& 'guahaorenyuan'==this.flag){
                             this.$message.error('挂号人员头像不能为空');
                             return
                         }

                         if((!this.ruleForm.huajiarenyuanName)&& 'huajiarenyuan'==this.flag){
                             this.$message.error('划价人员姓名不能为空');
                             return
                         }

                             if( 'huajiarenyuan' ==this.flag && this.ruleForm.huajiarenyuanPhone&&(!isMobile(this.ruleForm.huajiarenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.huajiarenyuanIdNumber)&& 'huajiarenyuan'==this.flag){
                             this.$message.error('划价人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.huajiarenyuanPhoto)&& 'huajiarenyuan'==this.flag){
                             this.$message.error('划价人员头像不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengName)&& 'yisheng'==this.flag){
                             this.$message.error('医生姓名不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengPhone)&& 'yisheng'==this.flag){
                             this.$message.error('医生联系方式不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengPhoto)&& 'yisheng'==this.flag){
                             this.$message.error('医生头像不能为空');
                             return
                         }

                         if((!this.ruleForm.keshiTypes)&& 'yisheng'==this.flag){
                             this.$message.error('科室不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiweiTypes)&& 'yisheng'==this.flag){
                             this.$message.error('职位不能为空');
                             return
                         }

                         if((!this.ruleForm.guahaofei)&& 'yisheng'==this.flag){
                             this.$message.error('挂号费不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && this.flag!='users' && this.flag!='shangjia'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
